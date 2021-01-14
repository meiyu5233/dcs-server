package com.tmxbase.dcsserver.util;

import com.google.common.base.Strings;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.seimicrawler.xpath.JXDocument;
import org.seimicrawler.xpath.JXNode;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Designation:
 * @Author: Ylz
 * @Date: 2019/12/13
 * @Version: 1.0
 */
public class ElementUtil {

    private ElementUtil() {
    }

    private static final String NULL = "";
    private static final String BODY = "//body";
    private static final int MIN_SIZE = 1;

    public static final Set<String> TAGS_CAN_BE_REMOVE_IF_EMPTY = Sets.newHashSet("section", "h1", "h2", "h3", "h4", "h5", "h6", "span");
    public static final Set<String> TAGS_MAY_HAVE_CONTENT = Sets.newHashSet("div", "span");
    public static final Set<String> MERGE_TAG = Sets.newHashSet("strong", "span");
    public static final Set<String> USELESS_TAG = Sets.newHashSet("style",
            "script",
            "link",
            "video",
            "iframe",
            "source",
            "picture",
            "header",
            "blockquote");
    public static final Set<String> USELESS_ATTR = Sets.newHashSet("share",
            "contribution",
            "copyright",
            "copy-right",
            "disclaimer",
            "recommend",
            "related",
            "footer",
            "comment",
            "social",
            "submeta",
            "report-infor");

    public static Element preParse(String html, String contentTag) {
        html = html.replaceAll("</?br.*?>", NULL).replaceAll("(?is)<img.*?>", NULL);
        Document doc = Jsoup.parse(html);
        //body中寻找正文
        Element body = doc.body();
        normaliseElement(body, contentTag);
        return body;
    }

    public static Element preParse(Element element, String contentTag) {
        return preParse(element.outerHtml(), contentTag);
    }

    /**
     * 选出我们需要的节点
     *
     * @param element
     */
    public static List<Element> normaliseElement(Element element, String contentTag) {
        List<Element> allElements = element.getAllElements().stream().collect(Collectors.toList());
        for (Element ele : allElements) {
            String tagName = ele.tagName();
            if (USELESS_TAG.contains(tagName)) {
                remove(ele);
            }
            if (TAGS_CAN_BE_REMOVE_IF_EMPTY.contains(tagName) && elementIsNull(ele)) {
                remove(ele);
            }
            if (StringUtils.equals(tagName, contentTag)) {
                mergeText(ele);
            }
            /**
             * 存在div 标签是正文,替换成contentTag.
             */
            if (TAGS_MAY_HAVE_CONTENT.contains(tagName) && ele.getAllElements().size() == MIN_SIZE) {
                ele.tagName(contentTag);
            }
            /**
             * 节点为空的
             */
            if (StringUtils.equals(tagName, contentTag) && elementIsNull(ele)) {
                remove(ele);
            }

            if (!Objects.isNull(ele.parent()) && USELESS_ATTR.contains(ele.tagName())) {
                remove(ele);
            }
        }
        return allElements;
    }

    public static void remove(Element element) {
        try {
            if (!Objects.isNull(element.parent())) {
                element.remove();
            }
        } catch (Exception e) {
        }
    }

    public static void removeAll(List<JXNode> jxNodes) {
        jxNodes.forEach(jxNode -> remove(jxNode.asElement()));
    }

    private static boolean isExistTag(Node node, String rule) {
        JXDocument jxDocument = JXDocument.create(node.outerHtml());
        JXNode jxNode = jxDocument.selNOne(rule);
        return !Objects.isNull(jxNode);
    }

    private static boolean elementIsNull(Element element) {
        String text = element.text();
        return Strings.isNullOrEmpty(text);
    }

    /**
     * 所有的element
     *
     * @param element
     * @param res
     */
    public static void iteratorElement(Element element, List<Element> res) {
        List<Node> nodeList = element.childNodes();
        List<Element> elements = nodeList.stream().filter(node -> isElement(node)).map(node -> (Element) node).collect(Collectors.toList());
        res.addAll(elements);
        for (Element item : elements) {
            iteratorElement(item, res);
        }
    }

    public static void iteratorNode(Node node, List<Node> res) {
        List<Node> nodes = node.childNodes().stream().collect(Collectors.toList());
        for (Node childNode : nodes) {
            if (childNode instanceof TextNode) {
                res.add(childNode);
            } else if (childNode instanceof Element) {
                int size = ((Element) childNode).getAllElements().size();
                String tagName = ((Element) childNode).tagName();
                if (size > MIN_SIZE && MERGE_TAG.contains(tagName)) {
                    res.add(childNode);
                    iteratorNode(childNode, res);
                } else {
                    res.add(childNode);
                }

            }
        }
    }

    private static boolean isElement(Node node) {
        return node instanceof Element;
    }

    /**
     * example:
     * "<html>" +
     * <head> +
     * <title>演示合并节点</title>" +
     * </head>" +
     * <body>" +
     * <div>" +
     * <p>你好,<span>世界;</span>你好，<a> fdsijifji<a /><span>产品经理</span></p>
     * </div>" +
     * </body>" +
     * "</html>"
     *
     * <p> 你好,世界;你好，产品经理</p>
     * 合并子节点的文本到父节点
     *
     * @param element
     */
    public static void mergeText(Element element) {
        Node preNode = null;
        List<Node> nodeList = new ArrayList<>();
        iteratorNode(element, nodeList);
        StringBuilder sb = new StringBuilder();
        for (Node node : nodeList) {
            if (node instanceof TextNode || !MERGE_TAG.contains(((Element) node).tagName())) {
                preNode = node;
                if (!Objects.isNull(sb)) {
                    node.before(sb.toString());
                    sb = null;
                }
            } else {
                if (Objects.isNull(preNode)) {
                    sb.append(((Element) node).ownText());
                } else {
                    preNode.after(((Element) node).ownText());
                }
                remove((Element) node);
            }
        }

        if (!Objects.isNull(sb)) {
            element.appendText(sb.toString());
        }
    }

    /**
     * 删除噪音节点
     *
     * @param html
     * @param noiseXpathList(指定xpath删除)
     */
    public static Element removeNoiseNode(String html, List<String> noiseXpathList) {
        JXDocument jxDocument = JXDocument.create(html);
        if (!CollectionUtils.isEmpty(noiseXpathList)) {
            noiseXpathList.stream().map(xpath -> jxDocument.selN(xpath))
                    .forEach(node -> removeAll(node));
        }
        return jxDocument.selNOne(BODY).asElement();
    }
}
