package com.tmxbase.dcsserver.util;

import com.time.nlp.TimeNormalizer;
import com.time.nlp.TimeUnit;
import com.tmxbase.utils.DateUtil;
import org.assertj.core.util.Lists;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Designation:
 * @Author: Ylz
 * @Date: 2019/10/17
 * @Version: 1.0
 */
public class TimeUtil {

    private TimeUtil() {
    }

    private static final String RESOURCE_PATH = "/TimeExp.m";
    private static TimeNormalizer normalizer;
    private static URL url;
    private static final String EN_FORMAT_LONG = "dd-MM-yyyy HH:mm:ss";
    private static final String EN_FORMAT_NO_SEC = "dd-MM-yyyy HH:mm";
    private static final String EN_FORMAT = "dd-MM-yyyy";

    private static final List<String> timeRule = Lists.newArrayList("\\d{4}[-|/|.]\\d{1,2}[-|/|.]\\d{1,2}\\s*?[0-1]?[0-9]:[0-5]?[0-9]:[0-5]?[0-9]",
            "\\d{4}[-|/|.]\\d{1,2}[-|/|.]\\d{1,2}\\s*?[2][0-3]:[0-5]?[0-9]:[0-5]?[0-9]",
            "\\d{4}[-|/|.]\\d{1,2}[-|/|.]\\d{1,2}\\s*?[0-1]?[0-9]:[0-5]?[0-9]",
            "\\d{4}[-|/|.]\\d{1,2}[-|/|.]\\d{1,2}\\s*?[2][0-3]:[0-5]?[0-9]",
            "\\d{4}[-|/|.]\\d{1,2}[-|/|.]\\d{1,2}\\s*?[1-24]\\d时[0-60]\\d分[1-24]\\d时",
            "\\d{2}[-|/|.]\\d{1,2}[-|/|.]\\d{1,2}\\s*?[0-1]?[0-9]:[0-5]?[0-9]:[0-5]?[0-9]",
            "\\d{2}[-|/|.]\\d{1,2}[-|/|.]\\d{1,2}\\s*?[2][0-3]:[0-5]?[0-9]:[0-5]?[0-9]",
            "\\d{2}[-|/|.]\\d{1,2}[-|/|.]\\d{1,2}\\s*?[0-1]?[0-9]:[0-5]?[0-9]",
            "\\d{2}[-|/|.]\\d{1,2}[-|/|.]\\d{1,2}\\s*?[2][0-3]:[0-5]?[0-9]",
            "\\d{2}[-|/|.]\\d{1,2}[-|/|.]\\d{1,2}\\s*?[1-24]\\d时[0-60]\\d分[1-24]\\d时",
            "\\d{4}年\\d{1,2}月\\d{1,2}日\\s*?[0-1]?[0-9]:[0-5]?[0-9]:[0-5]?[0-9]",
            "\\d{4}年\\d{1,2}月\\d{1,2}日\\s*?[2][0-3]:[0-5]?[0-9]:[0-5]?[0-9]",
            "\\d{4}年\\d{1,2}月\\d{1,2}日\\s*?[0-1]?[0-9]:[0-5]?[0-9]",
            "\\d{4}年\\d{1,2}月\\d{1,2}日\\s*?[2][0-3]:[0-5]?[0-9]",
            "\\d{4}年\\d{1,2}月\\d{1,2}日\\s*?[1-24]\\d时[0-60]\\d分[1-24]\\d时",
            "\\d{2}年\\d{1,2}月\\d{1,2}日\\s*?[0-1]?[0-9]:[0-5]?[0-9]:[0-5]?[0-9]",
            "\\d{2}年\\d{1,2}月\\d{1,2}日\\s*?[2][0-3]:[0-5]?[0-9]:[0-5]?[0-9]",
            "\\d{2}年\\d{1,2}月\\d{1,2}日\\s*?[0-1]?[0-9]:[0-5]?[0-9]",
            "\\d{2}年\\d{1,2}月\\d{1,2}日\\s*?[2][0-3]:[0-5]?[0-9]",
            "\\d{2}年\\d{1,2}月\\d{1,2}日\\s*?[1-24]\\d时[0-60]\\d分[1-24]\\d时",
            "\\d{1,2}月\\d{1,2}日\\s*?[0-1]?[0-9]:[0-5]?[0-9]:[0-5]?[0-9]",
            "\\d{1,2}月\\d{1,2}日\\s*?[2][0-3]:[0-5]?[0-9]:[0-5]?[0-9]",
            "\\d{1,2}月\\d{1,2}日\\s*?[0-1]?[0-9]:[0-5]?[0-9]",
            "\\d{1,2}月\\d{1,2}日\\s*?[2][0-3]:[0-5]?[0-9]",
            "\\d{1,2}月\\d{1,2}日\\s*?[1-24]\\d时[0-60]\\d分[1-24]\\d时",
            "\\d{4}[-|/|.]\\d{1,2}[-|/|.]\\d{1,2}",
            "\\d{2}[-|/|.]\\d{1,2}[-|/|.]\\d{1,2}",
            "\\d{4}年\\d{1,2}月\\d{1,2}日",
            "\\d{2}年\\d{1,2}月\\d{1,2}日",
            "\\d{1,2}月\\d{1,2}日");

    private static List<String> formatList = Lists.newArrayList(DateUtil.LONG_WEB_FORMAT, DateUtil.WEB_FORMAT, DateUtil.LONG_WEB_FORMAT_NO_SEC,
            DateUtil.LONG_WEB_FORMAT, EN_FORMAT_LONG, EN_FORMAT, EN_FORMAT_NO_SEC);

    static {
        url = TimeNormalizer.class.getResource(RESOURCE_PATH);
    }

    /**
     * 2019-2-2 和 2-2-2019的填充为2019-02-02和02-02-2019
     *
     * @param date
     * @return
     */
    private static String recoverDate(String date) {
        StringBuilder sb = new StringBuilder(date);
        int fill = 0;
        int length = 6;
        String flag = "-";
        //2019-2-2 和 2-2-2019
        if (date.lastIndexOf(flag) > length) {
            sb.insert(date.indexOf(flag), fill).insert(date.lastIndexOf(flag), fill);
        } else {
            sb.insert(0, fill).insert(date.indexOf(flag), fill);
        }
        return sb.toString();
    }

    public static Date getDate(String date) {
        date = date.replaceAll("[/|.]", "-");
        Date res = null;
        //符合2019-2-2情况
        if (date.length() < 9) {
            date = recoverDate(date);
        }

        for (String formatRule : formatList) {
            try {
                res = DateUtil.parse(date, formatRule);
                if (!Objects.isNull(res)) {
                    return res;
                }
            } catch (Exception e) {
            }
        }

        return res;
    }

    public static String getStringTime(String time, List<String> timeRule) {
        for (String rule : timeRule) {
            Pattern p = Pattern.compile(rule);
            Matcher m = p.matcher(time);
            if (m.find()) {
                return m.group().trim();
            }
        }
        return null;
    }

    public static Date getChineseDate(String time) throws URISyntaxException {
        normalizer = new TimeNormalizer(url.toURI().toString());
        normalizer.setPreferFuture(true);
        TimeUnit[] parse = normalizer.parse(time);
        return parse[0].getTime();
    }

    public static String getStringTime(String text) {
        return getStringTime(text.replaceAll("\\s*", ""), timeRule);
    }
}
