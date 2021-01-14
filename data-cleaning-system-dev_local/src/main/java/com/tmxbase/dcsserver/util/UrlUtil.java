package com.tmxbase.dcsserver.util;

import com.google.common.net.InternetDomainName;
import com.tmxbase.utils.StringUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Designation:
 * @Author: Ylz
 * @Date: 2019/10/16
 * @Version: 1.0
 */
public class UrlUtil {

    private UrlUtil() {
    }

    private static final String MUN = "^[0-9]*$";

    public static String getDomain(String domain) {
        Pattern p = Pattern.compile("(?<=//|)((\\w)+\\.)+\\w+");
        Matcher m = p.matcher(domain);
        return m.find() == true ? m.group() : null;
    }

    public static boolean numCheck(String str) {
        Pattern pattern = Pattern.compile(MUN);
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    public static boolean defaultQueryNumCheck(String url) {
        return queryNumCheck(url, "/", ".");
    }

    public static boolean queryNumCheck(String url, String startFlag, String endFlag) {
        int start = url.lastIndexOf(startFlag) + 1;
        int end = url.lastIndexOf(endFlag);
        if (end < start) {
            end = url.length();
        }
        return UrlUtil.numCheck(StringUtil.substring(url, start, end));
    }

    public static boolean numExist(String str) {
        Pattern p = Pattern.compile(".*\\d+.*");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public static boolean divideCheck(String url, int num) {
        char[] charArray = url.toCharArray();
        int i = 0;
        for (char c : charArray) {
            if (c == '/') {
                i++;
            }
        }
        return i > num;
    }

    /**
     * 获取主域名
     *
     * @param link
     * @return
     */
    public static String getHost(String link) {
        return InternetDomainName.from(link).parent().toString();
    }

}
