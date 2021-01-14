package com.tmxbase.dcsserver.base.model;

import com.google.common.base.Strings;
import com.tmxbase.dcsserver.util.ElementUtil;
import com.tmxbase.dcsserver.util.NewsExtractorUtil;
import com.tmxbase.dcsserver.util.TimeUtil;
import lombok.Data;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @Designation:
 * @Author: Ylz
 * @Date: 2019/10/14
 * @Version: 1.0
 */
@Data
public class Page {

    public static Logger logger = LoggerFactory.getLogger(Page.class);

    public String html;
    public String url;

    public Page(String html, String url) {
        this.html = html;
        this.url = url;
    }


    public String getText(String html) {
        String text = NewsExtractorUtil.getGeneralText(html);
        String result = text.replaceAll("/r/n", "");
        return result;
    }

    /**
     * 提取正文的通用方法
     *
     * @return
     */
    public String getText(String contentTag, List<String> noiseNodeList) {
        String text = NewsExtractorUtil.getGeneralText(html, contentTag, noiseNodeList);
        String result = text.replaceAll("/r/n", "");
        return result;
    }


    /**
     * 提取标题通用方法
     *
     * @return
     */
    public String getTitle() {
        return Jsoup.parse(html).title();
    }

    /**
     * 获取文中时间
     *
     * @return
     */
    public Date getTime(String contentTag) {
        Element element = ElementUtil.preParse(html, contentTag);
        String text = element.text();
        Date modifyDate = new Date();
        Date date;
        try {
            String time = TimeUtil.getStringTime(text);
            if (Strings.isNullOrEmpty(time)) {
                time = TimeUtil.getStringTime(html);
            }
            //解析数字时间
            date = TimeUtil.getDate(time);
            if (Objects.isNull(date)) {
                // 可能包含中文,用中文解析
                date = TimeUtil.getChineseDate(time);
            }
        } catch (Exception e) {
            logger.error("html time is error url: {}", url);
            return modifyDate;
        }
        //小时为单位无法识别.使用当前时间代替
        return Optional.ofNullable(date).orElse(modifyDate);
    }


}
