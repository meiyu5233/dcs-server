package com.tmxbase.dcsserver.service;

import com.google.common.base.Strings;
import com.tmxbase.dcsserver.service.factory.HtmlExtractor;
import com.tmxbase.dcsserver.util.ElementUtil;
import com.tmxbase.dcsserver.util.TimeUtil;
import com.tmxbase.utils.LoggerUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.seimicrawler.xpath.JXDocument;
import org.seimicrawler.xpath.JXNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class NewsExtractor implements HtmlExtractor {
    private static final Logger logger = LoggerFactory.getLogger(NewsExtractor.class);

    public static NewsExtractor newsExtractor;

    public static synchronized NewsExtractor getInstance() {
        if (newsExtractor == null) {
            newsExtractor = new NewsExtractor();
        }
        return newsExtractor;
    }

    public static final String TI_RULE = ".//text()";
    public static final String SPRIT = ".//";
    public static final String LINE_REG = "(\r\n|\r|\n|\n\r)";
    public static final String NULL = "";
    public static final String LTI_RULE = ".//a//text()";
    public static final String BLACK = "\\s+";
    public static final String TGI_RULE = ".//*";
    public static final String LTGI_RULE = ".//a";

    private static final String SYMBOL = "'''！，。？、；：“”‘’《》%（）,.?:;'\"!%()'''【】——……—·〈〉「」";
    private static final Set<Character> CHARACTER_SET = SYMBOL.chars().mapToObj(item -> (char) item).collect(Collectors.toSet());

    public static final double MIN_STANDARD_DEVIATION = 2.0;

    @Override
    public String getTitle(String htmlString) {
        return Jsoup.parse(htmlString).title();
    }

    @Override
    public String getText(String htmlString, String contentTag, List<String> noiseNodeList) {
        Element element = ElementUtil.removeNoiseNode(htmlString, noiseNodeList);
        element = ElementUtil.preParse(element, contentTag);
        List<Element> allElements = element.getAllElements().stream().collect(Collectors.toList());
        /**
         * 计算标准差
         */
        double standardDeviation = getStandardDeviation(allElements);
        standardDeviation = standardDeviation < MIN_STANDARD_DEVIATION ? MIN_STANDARD_DEVIATION : standardDeviation;
        Map<Double, Element> scoreMap = new TreeMap<>(Comparator.comparing(Double::doubleValue).reversed());

        for (Element ele : allElements) {
            double score = getScore(ele, standardDeviation, contentTag);
            scoreMap.put(score, ele);
        }

        /**
         * 获取得分最高的element
         */
        Map.Entry<Double, Element> firstEntry = ((TreeMap<Double, Element>) scoreMap).firstEntry();
        String text = getElementText(firstEntry.getValue(), TI_RULE);
        LoggerUtil.info(logger, "html 文本" + text);
        return text;
    }

    @Override
    public Date getTime(String htmlString, String contentTag) {
        Element element = ElementUtil.preParse(htmlString, contentTag);
        String text = element.text();
        Date modifyDate = new Date();
        Date date;
        try {
            String time = TimeUtil.getStringTime(text);
            if (Strings.isNullOrEmpty(time)) {
                time = TimeUtil.getStringTime(htmlString);
            }
            //解析数字时间
            date = TimeUtil.getDate(time);
            if (Objects.isNull(date)) {
                // 可能包含中文,用中文解析
                date = TimeUtil.getChineseDate(time);
            }
        } catch (Exception e) {
            return modifyDate;
        }
        //小时为单位无法识别.使用当前时间代替
        return Optional.ofNullable(date).orElse(modifyDate);
    }

    /**
     * 计算节点文本密度标准差
     *
     * @param elements
     * @return
     */
    private static double getStandardDeviation(List<Element> elements) {
        List<Double> nodeTextDensityList = elements.parallelStream().map(node -> getElementTextDensity(node)).collect(Collectors.toList());
        double average = nodeTextDensityList.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
        double variance = nodeTextDensityList.stream().mapToDouble(item -> Math.pow(item - average, 2)).average().getAsDouble();
        double result = Math.sqrt(variance);
        return result;
    }

    /**
     * 得分
     * score = log(SD)*NDi* log 10(PNumi+ 2)* log(SbDi)
     * SD：节点文本密度的标准差。
     * NDi ：节点i 的文本密度。
     * PNumi ：节点i 的p 标签数；
     * SbDi ：符号密度；
     *
     * @param element
     * @param standardDeviation
     * @param contentTag
     * @return
     */
    private static double getScore(Element element, double standardDeviation, String contentTag) {
        double score;
        double ndi = getElementTextDensity(element);
        int pNumi = getElementTextNum(element, SPRIT, contentTag);
        double symbolDensity = getSymbolDensity(element);
        score = Math.log(standardDeviation) * ndi * Math.log10(pNumi + 2) * Math.log(symbolDensity);
        if (Double.isNaN(score)) {
            score = 0;
        }
        return score;
    }

    /**
     * 获取节点文本密度
     * TDi=(Ti-LTi)/(TGi-LTGi)
     * Ti ：结点i 的字符串字数。
     * LTi ：结点i 的带链接的字符串字数。
     * TGi ：结点i 的标签数。
     * LTGi ：结点i 带链接的标签数。
     *
     * @param element
     * @return
     */
    private static double getElementTextDensity(Element element) {
        int ti = getElementText(element, TI_RULE).replaceAll(LINE_REG, NULL).replaceAll(BLACK, NULL).length();
        int lti = getElementText(element, LTI_RULE).replaceAll(LINE_REG, NULL).replaceAll(BLACK, NULL).length();
        double tgi = getElementNum(element, TGI_RULE);
        double ltgi = getElementNum(element, LTGI_RULE);
        return (tgi - ltgi) == 0 ? 0 : (ti - lti) / (tgi - ltgi);
    }

    /**
     * 获取当前节点的文本
     *
     * @param element
     * @param rule    获取文本的规则
     * @return
     */
    public static String getElementText(Element element, String rule) {
        JXDocument jxDocument = JXDocument.create(element.outerHtml());
        List<JXNode> jxNodes = jxDocument.selN(rule);
        StringBuilder sb = new StringBuilder();
        jxNodes.forEach(jxNode -> sb.append(jxNode.toString()).append("\r\n"));
        return sb.toString().replaceAll("(?is)<img.*?>", NULL);
    }

    private static int getElementTextNum(Element element, String rule, String contentTag) {
        String text = element.toString();
        JXDocument jxDocument = JXDocument.create(text);
        List<JXNode> nodes = jxDocument.selN(rule + contentTag);
        int num = nodes.size();
        return num;
    }

    /**
     * 符号密度
     * SbDi = (Ti-LTi) / (Sbi+ 1)（4）
     * 符号密度为文字数量与符号数量的比值，根据
     * 我们的经验，通常正文的SbDi 会比非正文要大。非
     * 正文可能没有符号，而且由于非正文通常会比较少
     * 字，可能就是一些导航的信息之类的，所以，在相同
     * 字数下它的SbDi 相对正文来说就会比较小。
     *
     * @return
     */
    private static double getSymbolDensity(Element element) {
        String ti = getElementText(element, TI_RULE).replaceAll(LINE_REG, NULL).replaceAll(BLACK, NULL);
        String lti = getElementText(element, LTI_RULE).replaceAll(LINE_REG, NULL).replaceAll(BLACK, NULL);
        int symbolNum = getSymbolNum(ti);
        double res = (ti.length() - lti.length()) / (symbolNum + 1);
        return res == 0 ? 1 : res;
    }

    /**
     * 当前节点的标签数
     *
     * @param element
     * @param rule    获取标签的规则
     * @return
     */
    private static double getElementNum(Element element, String rule) {
        JXDocument jxDocument = JXDocument.create(element.toString());
        List<JXNode> nodes = jxDocument.selN(rule);
        return nodes.size();
    }

    /**
     * 符号数量
     *
     * @param text
     * @return
     */
    private static int getSymbolNum(String text) {
        long count = text.chars().mapToObj(item -> (char) item)
                .filter(item -> CHARACTER_SET.contains(item))
                .count();
        return (int) count;
    }
}
