package com.tmxbase.dcsserver.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TextExtractUtil {
    // 块厚度
    private static int blocksWidth = 3;
    // 块长度阈值
    private static int threshold = 86;
    private static int englishThreshold = 66;

    private TextExtractUtil() {
    }

    public static void setthreshold(int value) {
        threshold = value;
    }

    /**
     * @param html html源码
     * @return 网页正文
     */
    public static String parse(String html) {
        html = preProcess(html);
        String text = getText(html);
        return text;
    }

    /**
     * @param html html源码保留空格
     * @return 网页正文
     */
    public static String parseBlank(String html) {
        setthreshold(englishThreshold);
        html = preProcess(html);
        String text = getEnglishText(html);
        return text;
    }

    /**
     * 去掉所有不可能是正文的内容
     *
     * @param html html源码
     * @return
     */
    public static String preProcess(String html) {
        html = html.replaceAll("(?is)<!DOCTYPE.*?>", "")
                .replaceAll("(?is)<!--.*?-->", "")
                .replaceAll("(?is)<script.*?>.*?</script>", "")
                .replaceAll("(?is)<style.*?>.*?</style>", "")
                .replaceAll("&.{2,5};|&#.{2,5};", " ")
                .replaceAll("(?is)<.*?>", "");
        return html;
    }

    private static String getEnglishText(String candidate) {
        List<String> lineList = Arrays.asList(candidate.split("(\n\r|\n|\r)+ "));
        removeEnglishSpace(lineList);

        List<Integer> indexDistribution = computeIndexDistribution(lineList);

        int maxLengthBlockIndex = findMaxLengthBlock(indexDistribution);

        // 寻找起点
        int startIndex = findStart(indexDistribution, maxLengthBlockIndex);
        // 寻找终点
        int endIndex = findEnd(indexDistribution, maxLengthBlockIndex);

        StringBuilder sb = new StringBuilder();
        for (int i = startIndex; i <= endIndex; i++) {
            sb.append(lineList.get(i)).append("/r/n");
        }

        return sb.toString();
    }

    /**
     * @param candidate html源码被预处理之后的结果
     * @return 网页正文
     */
    private static String getText(String candidate) {
        List<String> lineList = Arrays.asList(candidate.split("(\n\r|\n|\r)+ "));
        removeAllSpace(lineList);

        List<Integer> indexDistribution = computeIndexDistribution(lineList);

        int maxLengthBlockIndex = findMaxLengthBlock(indexDistribution);

        // 寻找起点
        int startIndex = findStart(indexDistribution, maxLengthBlockIndex);
        // 寻找终点
        int endIndex = findEnd(indexDistribution, maxLengthBlockIndex);

        StringBuilder sb = new StringBuilder();
        for (int i = startIndex; i <= endIndex; i++) {
            sb.append(lineList.get(i)).append("/r/n");
        }

        return sb.toString();
    }

    /**
     * 删除掉一行文本中的所有空白
     *
     * @param line
     * @return
     */
    private static String removeSpace(String line) {
        line = line.replaceAll("\\s+", "");
        return line;
    }

    /**
     * 删除掉一行文本中的连续空白
     *
     * @param line
     * @return
     */
    private static String removeEnglishSpace(String line) {
        line = line.replaceAll("\\s{3,}", "");
        return line;
    }

    /**
     * 删除多行文本中的所有空白
     *
     * @param lineList
     */
    private static void removeAllSpace(List<String> lineList) {
        int size = lineList.size();
        for (int i = 0; i < size; i++) {
            String temp = removeSpace(lineList.get(i));
            lineList.set(i, temp);
        }
    }

    /**
     * 删除多行文本中的过多空白
     *
     * @param lineList
     */
    private static void removeEnglishSpace(List<String> lineList) {
        int size = lineList.size();
        for (int i = 0; i < size; i++) {
            String temp = removeEnglishSpace(lineList.get(i));
            lineList.set(i, temp);
        }
    }

    /**
     * @param lineList 由html预处理后的文本分解得到的所有行
     * @return 块号-长度统计信息
     */
    private static List<Integer> computeIndexDistribution(List<String> lineList) {
        List<Integer> indexDistribution = new ArrayList<>();
        for (int i = 0; i < lineList.size() - blocksWidth; i++) {
            int wordsNum = 0;
            // 去掉行中所有空白符，然后统计字符总数
            for (int j = i; j < i + blocksWidth; j++) {
                wordsNum += lineList.get(j).length();
            }
            indexDistribution.add(wordsNum);
        }
        return indexDistribution;
    }

    /**
     * @param indexDistribution 块号-长度统计信息
     * @return 长度最大的块的索引
     */
    private static int findMaxLengthBlock(List<Integer> indexDistribution) {
        int size = indexDistribution.size();
        int maxLengthBlockIndex = 0;
        int maxLength = indexDistribution.get(0);
        for (int i = 1; i < size; i++) {
            int length = indexDistribution.get(i);
            if (length > maxLength) {
                maxLength = length;
                maxLengthBlockIndex = i;
            }
        }
        return maxLengthBlockIndex;
    }

    /**
     * 从maxLengthBlockIndex向前寻找起点
     *
     * @param indexDistribution   块号-长度统计信息
     * @param maxLengthBlockIndex 长度最大的块的索引
     * @return
     */
    private static int findStart(List<Integer> indexDistribution, int maxLengthBlockIndex) {
        int i = maxLengthBlockIndex - 1;
        for (; i >= 0; i--) {
            if (indexDistribution.get(i) < threshold) {
                break;
            }
        }
        return i + 1;
    }

    /**
     * 从maxLengthBlockIndex向后寻找终点
     *
     * @param indexDistribution   块号-长度统计信息
     * @param maxLengthBlockIndex 长度最大的块的索引
     * @return
     */
    private static int findEnd(List<Integer> indexDistribution, int maxLengthBlockIndex) {
        int size = indexDistribution.size();
        int i = maxLengthBlockIndex + 1;
        for (; i < size; i++) {
            if (indexDistribution.get(i) < threshold) {
                break;
            }
        }
        return i;
    }
}
