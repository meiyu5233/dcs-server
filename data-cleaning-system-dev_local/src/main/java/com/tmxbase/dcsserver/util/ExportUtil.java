package com.tmxbase.dcsserver.util;

import com.google.common.io.Files;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Designation:
 * @Author: Ylz
 * @Date: 2019/11/7
 * @Version: 1.0
 */
public class ExportUtil {

    public static void createCell(Cell cell, XSSFCellStyle cellStyle, Object text) {
        if (text instanceof Integer) {
            cell.setCellValue((int) text);
        } else {
            cell.setCellType(CellType.STRING);
            cell.setCellValue(String.valueOf(text));
        }
        cell.setCellStyle(cellStyle);
    }

    public static void main(String[] args) throws IOException {
        createReport();
    }

    public static void createReport() throws IOException {
        File file = new File("C:\\all\\越南语料.txt");
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet();

        Row headRow = sheet.createRow(0);
        Row secondRow = sheet.createRow(1);

        //正文类型
        XSSFCellStyle cellStyleText = (XSSFCellStyle) wb.createCellStyle();
        cellStyleText.setAlignment(HorizontalAlignment.LEFT);
        cellStyleText.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyleText.setWrapText(true);
        Row Row = sheet.createRow(0);
        createCell(Row.createCell(0), cellStyleText, "篇数序号");
        createCell(Row.createCell(1), cellStyleText, "标题");
        createCell(Row.createCell(2), cellStyleText, "来源");
        createCell(Row.createCell(3), cellStyleText, "国家");
        createCell(Row.createCell(4), cellStyleText, "日期");
        createCell(Row.createCell(5), cellStyleText, "网址");
        createCell(Row.createCell(6), cellStyleText, "版面");
        createCell(Row.createCell(7), cellStyleText, "作者");
        createCell(Row.createCell(8), cellStyleText, "关键词");
        createCell(Row.createCell(9), cellStyleText, "转载情况");
        List<String> list = Files.readLines(file, Charset.defaultCharset());
        int textIndex = 1;
        int index = 0;
        Row textRow = sheet.createRow(textIndex);
        for (String text : list) {
            if (text.length() < 2) {
                continue;
            }
            if (text.contains("内容")) {
                index = 0;
                textRow = sheet.createRow(++textIndex);
                continue;
            }
            if (text.contains("篇")) {
                createCell(textRow.createCell(index++), cellStyleText, text);
            } else if (text.contains("网址")) {
                createCell(textRow.createCell(index++), cellStyleText, text.substring(3));
                createCell(textRow.createCell(index++), cellStyleText, "");
            } else if (text.contains("日期")) {

                String numDate = "\\d{2}/\\d{2}/\\d{4},\\s*((\\d{2}:){1,2}\\d{2})*";
                Pattern compile = Pattern.compile(numDate);
                Matcher matcher = compile.matcher(text.substring(3));
                if (matcher.find()) {
                    createCell(textRow.createCell(index++), cellStyleText, matcher.group());
                } else {
                    createCell(textRow.createCell(index++), cellStyleText, text.substring(3));
                }
            } else {
                String[] textArray = text.split(":");
                createCell(textRow.createCell(index++), cellStyleText, textArray[1]);
            }


        }
        wb.write(new FileOutputStream("C:\\all\\越南.xlsx"));
        wb.close();

    }

    public static void createTranslateReport(String srcLan, String tgtLan, List<String> srcList, Map<String, List<String>> tgtMap, String filePath) throws IOException {
        int EXCEL_WIDTH_STANDARD = 3;
        int excelReturnSize = 900;
        String lan = "语言方向: " + srcLan + "-" + tgtLan;
        //生成报告文件
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet();

        Row headRow = sheet.createRow(0);
        Row secondRow = sheet.createRow(1);
        //标题类型
        XSSFCellStyle cellStyleTitle = (XSSFCellStyle) wb.createCellStyle();
        cellStyleTitle.setAlignment(HorizontalAlignment.LEFT);
        cellStyleTitle.setVerticalAlignment(VerticalAlignment.BOTTOM);
        //正文类型
        XSSFCellStyle cellStyleText = (XSSFCellStyle) wb.createCellStyle();
        cellStyleText.setAlignment(HorizontalAlignment.LEFT);
        cellStyleText.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyleText.setWrapText(true);
        //第一行内容
        createCell(headRow.createCell(0), cellStyleTitle, lan);
        sheet.setColumnWidth(0, 30 * EXCEL_WIDTH_STANDARD);
        createCell(secondRow.createCell(0), cellStyleTitle, "原文");
        int headIndex = 1;

        for (String mtProvider : tgtMap.keySet()) {
            //单元格宽度设置
            sheet.setColumnWidth(headIndex, 30 * EXCEL_WIDTH_STANDARD);
            createCell(secondRow.createCell(headIndex++), cellStyleTitle, mtProvider);
        }
        //正文索引
        int textIndex = 2;
        int paragraphIndex = 0;
        //文本构建
        for (String srcText : srcList) {
            int index = 0;
            int maxLength = srcText.getBytes().length;
            Row textRow = sheet.createRow(textIndex++);
            createCell(textRow.createCell(index++), cellStyleText, srcText);
            for (List<String> tgtTextList : tgtMap.values()) {
                maxLength = Math.max(maxLength, tgtTextList.get(paragraphIndex).getBytes().length);
                createCell(textRow.createCell(index), cellStyleText, tgtTextList.get(paragraphIndex));
                index++;
            }
            //超过自动换行的限制手动设置行高
            if (maxLength > excelReturnSize) {
                textRow.setHeight((short) ((maxLength / 28) * EXCEL_WIDTH_STANDARD));
            }
            paragraphIndex++;
        }

        wb.write(new FileOutputStream(filePath));
        wb.close();
    }
}
