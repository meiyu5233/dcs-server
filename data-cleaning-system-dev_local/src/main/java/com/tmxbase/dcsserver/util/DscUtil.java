package com.tmxbase.dcsserver.util;

import com.tmxbase.utils.StringUtil;

import java.util.Date;

/**
 * @Designation:
 * @Author: Ylz
 * @Date: 2019/10/14
 * @Version: 1.0
 */
public class DscUtil {

    private DscUtil() {
    }

    //docId生成
    public static String docId(String content) {
        return StringUtil.md5(content);
    }

    //htmlId生成
    public static String htmlId(String url) {
        return StringUtil.getRandomId().substring(0, 4) + StringUtil.md5(url) + new Date().getTime();
    }

    //spiderFileId生成
    public static String getSpiderFileId() {
        return StringUtil.getRandomId() + new Date().getTime();
    }

    // SourceSiteId
    public static String generateSourceSiteId() {
        return StringUtil.getRandomId() + new Date().getTime();
    }
}
