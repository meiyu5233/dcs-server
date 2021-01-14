package com.tmxbase.dcsserver.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tmxbase.base.constants.FileConstants;
import com.tmxbase.dcsserver.base.constants.IndustryMapper;
import com.tmxbase.dcsserver.base.constants.SpiderConstants;
import com.tmxbase.dcsserver.base.model.CrawlerSource;
import com.tmxbase.dcsserver.base.model.RawDoc;
import com.tmxbase.dcsserver.base.model.SiteSource;
import com.tmxbase.dcsserver.dal.dao.CrawlerSourceSiteDAO;
import com.tmxbase.dcsserver.mq.producer.QueueProducer;
import com.tmxbase.dcsserver.service.crawler.WebCollectorGeneral;
import com.tmxbase.dcsserver.service.factory.ExtractorFactory;
import com.tmxbase.dcsserver.service.factory.HtmlExtractor;
import com.tmxbase.dcsserver.service.process.NLPAnalysisProcess;
import com.tmxbase.dcsserver.util.DscUtil;
import com.tmxbase.utils.*;
import com.tmxbase.utils.exception.TBException;
import com.tmxbase.utils.exception.code.SystemErrorCode;
import com.tmxbase.utils.segmentation.util.SRX;
import com.tmxbase.utils.segmentation.util.SRXUtil;
import org.apache.velocity.runtime.directive.Foreach;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("crawlerProcess")
public class CrawlerProcess {

    private static final Logger logger = LoggerFactory.getLogger(CrawlerProcess.class);

    @Autowired
    private QueueProducer queueProducer;
    @Autowired
    private NLPAnalysisProcess nlpAnalysisProcess;
    @Autowired
    private ExtractorFactory extractorFactory;
    @Autowired
    private CrawlerSourceSiteDAO crawlerSourceSiteDAO;


    @Value("${file.root.path}")
    private String path;

    public void webCollector(SiteSource siteSource) throws Exception {
        // 获取parser中数据
        String parserStr = siteSource.getParser();
        String[] parserArray = parserStr.split("\\|\\|\\|");
        String crawler = parserArray[0];
        List<String> regexList = new ArrayList<>();
        for (int i = 2; i < parserArray.length; i++) {
            regexList.add(parserArray[i]);
        }

        // 通过parser采用对应的爬虫
        if (StringUtil.equals(crawler, SpiderConstants.PARSER_WEBCOLLECTOR_GENERAL) && siteSource.getUseProxy() == 0) {
            // 初始化特定的爬虫实例
            WebCollectorGeneral webCollectorGeneral = new WebCollectorGeneral(path + siteSource.getSiteSourceName() + "_" + siteSource.getLan() + "_" + DateUtil.format(new Date(), DateUtil.SHORT_FORMAT) + "/", true, siteSource.getSiteSourceUri(), regexList, queueProducer);
            LoggerUtil.info(logger, "请求参数为：" + siteSource.getSiteSourceName() + siteSource.getLan() + siteSource.getSiteSourceUri() + regexList);
            webCollectorGeneral.execute(siteSource);
        }

    }

    public void crawlerSourceProcess(CrawlerSource crawlerSource) throws IOException {
        String filePath = crawlerSource.getCrawlerFilePath();

        String jsonString;
        JSONObject jsonObject;
        String htmlPath;
        String htmlString;
        String title;
        String content;
        String emotion;
        String industry;
        String summary;
        Date time;
        String rawDocString;

        InputStreamReader read;
        BufferedReader bufferedReader;

        HtmlExtractor htmlExtractor;

        RawDoc rawDoc;

        File file;

        // 创建对应文件
        String fileNum = filePath.substring(filePath.lastIndexOf("crawler") + 7, filePath.lastIndexOf("."));
        String packagePath = filePath.substring(0, filePath.length() - 12);
        File rawDocFile = new File(packagePath + "/rawDoc" + fileNum + ".txt");
        File f = new File(packagePath);
        if (f.exists()) {
            f.mkdirs(); //创建目录
        }
        if (!rawDocFile.exists()) {
            FileUtil.createFileAnyway(rawDocFile.getPath());
        }
        FileWriter fileWriter = new FileWriter(rawDocFile, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        file = new File(filePath);
        if (!file.exists()) {
            LoggerUtil.error(logger, new TBException(SystemErrorCode.INVALID_RESOURCE), "[crawlerSourceProcess] crawlerSource.filePath文件不存在");
            return;
        }

        read = new InputStreamReader(new FileInputStream(file));
        bufferedReader = new BufferedReader(read);

        Date before;
        Date after;
        Date startTime;

        // 读取srx文件
        String lan = crawlerSource.getLan();
        ClassPathResource classPathResource;
        if (SegmentationRuleUtil.isCustomRule(lan)) {
            classPathResource = new ClassPathResource(lan + FileConstants.SUFFIX_SRX);
        } else {
            classPathResource = new ClassPathResource("template.srx");
        }

        // 初始化自定义的srx文件
        SRX srx = new SRX();
        srx.initSrx(classPathResource.getInputStream());
        int count = 0;

        while ((jsonString = bufferedReader.readLine()) != null) {
            startTime = new Date();
            jsonObject = JSON.parseObject(jsonString);
            htmlPath = jsonObject.getString("htmlPath");
            if (StringUtil.isBlank(htmlPath)) {
                LoggerUtil.error(logger, new TBException(SystemErrorCode.INVALID_OPERATION), "[crawlerSourceProcess] htmlPath不存在或布隆已存在");
                continue;
            }
            htmlString = readFileToString(htmlPath);
            LoggerUtil.info(logger, "[crawlerSourceProcess] htmlstring" + htmlString);
            htmlExtractor = extractorFactory.createExtractor(jsonObject.getString("extractor"));
            title = htmlExtractor.getTitle(htmlString);
            time = htmlExtractor.getTime(htmlString, "p");
            content = htmlExtractor.getText(htmlString, "p", null);
            LoggerUtil.info(logger, "HTMLString" + htmlString);
            if (StringUtil.isBlank(content) || content.length() < 200) {
                LoggerUtil.warn(logger, "[crawlerSourceProcess] content为空或者长度小于200");
                continue;
            }

            try {
                LoggerUtil.info(logger, "[crawlerSourceProcess] htmlPath:" + htmlPath);
                LoggerUtil.info(logger, "[crawlerSourceProcess] content:" + content);

                // 使用SRXUtil进行断句
                List<String> contentList = SRXUtil.segmentation(content, lan, srx);

                before = new Date();
                emotion = nlpAnalysisProcess.evaluateSentiment(content);
                after = new Date();
                LoggerUtil.info(logger, "[crawlerSourceProcess] 生成rawDoc.emotion,name=" + crawlerSource.getSiteSourceName() + ", 耗时:" + DateUtil.getDiffMilliSeconds(before, after) + "ms");
                before = new Date();
                industry = nlpAnalysisProcess.evaluateIndustry(content);
                after = new Date();
                LoggerUtil.info(logger, "[crawlerSourceProcess] 生成rawDoc.industry,name=" + crawlerSource.getSiteSourceName() + ", 耗时:" + DateUtil.getDiffMilliSeconds(before, after) + "ms");

                before = new Date();
                if (contentList.size() < 6) {
                    summary = content;
                } else {
                    summary = nlpAnalysisProcess.evaluateSummary(contentList);
                }
                after = new Date();
                LoggerUtil.info(logger, "[crawlerSourceProcess] 生成rawDoc.summary,name=" + crawlerSource.getSiteSourceName() + ", 耗时:" + DateUtil.getDiffMilliSeconds(before, after) + "ms");

                rawDoc = new RawDoc(DscUtil.docId(title), content, summary, title, crawlerSource.getMedia(), Byte.parseByte(emotion), crawlerSource.getPlatform(),
                        crawlerSource.getSource(), IndustryMapper.getIndustry(Integer.parseInt(industry)), crawlerSource.getLan(), jsonObject.getString("url"), htmlPath,
                        htmlPath, crawlerSource.getCountry(), DateUtil.format(time, DateUtil.LONG_WEB_FORMAT), DateUtil.format(new Date(), DateUtil.LONG_WEB_FORMAT));

                rawDocString = "标题：" + JSON.toJSONString(rawDoc.getTitle()) + "\r\n" + JSON.toJSONString(rawDoc.getContent());
                rawDocString = rawDocString.replace("\"", "");
                String txtTitle = JSON.toJSONString(rawDoc.getTitle()).replace("\"", "");
//                String txtTitle = "习近平重要讲话(双语)" + count;
//                String txtTitle = getTitle(htmlString);
                StringBuilder stringBuilder = praseHtml2(htmlString);
                writeTXT("D:\\gitProject\\data-cleaning-system\\src\\main\\resources\\记者会2", txtTitle, stringBuilder.toString());
                printWriter.println(rawDocString);
                printWriter.flush();
                fileWriter.flush();

                LoggerUtil.info(logger, "[crawlerSourceProcess] 生成rawDoc,name=" + crawlerSource.getSiteSourceName() + ", 共耗时:" + DateUtil.getDiffMilliSeconds(startTime, new Date()) + "ms");
            } catch (Exception e) {
                ExceptionUtil.caught(e);
                LoggerUtil.error(logger, e, "[crawlerSourceProcess] 生成rawDoc失败 jsonString:" + jsonString);
                continue;
            }
            count++;
        }

        bufferedReader.close();
        read.close();

        printWriter.close();
        fileWriter.close();

        LoggerUtil.info(logger, "[crawlerSourceProcess] 执行结束:" + rawDocFile.getAbsolutePath());
    }

    public String readFileToString(String filePath) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bf = new BufferedReader(new FileReader(filePath));
        String string = "";
        while ((string = bf.readLine()) != null) {
            stringBuilder.append(string);
        }

        return stringBuilder.toString();
    }

    public static void writeTXT(String path, String title, String content) {
        try {
            // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw
            /* 写入Txt文件 */
            File writename = new File(path);// 相对路径，如果没有则要建立一个新的output。txt文件
            if (writename.exists()) {
                writename.mkdirs();
            }
            content = content.replaceAll(" 　　", "\r\n");
            content = content.replaceAll("     　", "\r\n");
            content = content.replaceAll("     ", "\r\n");
            System.out.println(title);
            writename = new File(path + "\\" + title + ".txt");// 相对路径，如果没有则要建立一个新的output。txt文件
            if (!writename.exists()) {
                FileUtil.createFileAnyway(writename.getPath());
            }
            ; // 创建新文件
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            out.write(content); // \r\n即为换行
            out.flush(); // 把缓存区内容压入文件
            out.close(); // 最后记得关闭文件

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String removeUrl(String commentstr) {
        String urlPattern = "(https?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]";
        return commentstr.replaceAll(urlPattern, "").trim();
    }

    public static StringBuilder praseHtml(String html) {
        StringBuilder stringBuilder = new StringBuilder();
        Document document = Jsoup.parse(html);
        System.out.println(document.getElementsByTag("title").text());
        Elements postList = document.getElementsByClass("apDiv1");
        for (Element postItem : postList) {
            Elements text = postItem.getElementsByTag("td");
            for (Element txt : text) {
                Elements t = txt.getElementsByTag("p");
                for (Element e : t) {
                    stringBuilder.append(e.text() + "\n");
                }
            }

        }
        return stringBuilder;
    }

    public static StringBuilder praseHtml2(String html) {
        StringBuilder stringBuilder = new StringBuilder();
//        html = html.replaceAll("<br />", "\r\n");
        Document document = Jsoup.parse(html);
        Elements postList = document.getElementsByClass("container");
        System.out.println(postList.text());
        for (Element postItem : postList) {
            Elements element = postItem.getElementsByTag("p");
            System.out.println(element.text());
            for (Element e : element) {
                stringBuilder.append(e.text() + "\n");
            }
        }
        return stringBuilder;
    }

    public static String getTitle(String html) {
        Document document = Jsoup.parse(html);
        String title = document.getElementsByClass("article-header").text();
        System.out.println(title);
        return title;
    }


}
