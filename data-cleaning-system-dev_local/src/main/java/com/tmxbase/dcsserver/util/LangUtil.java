package com.tmxbase.dcsserver.util;

import com.google.common.base.Optional;
import com.optimaize.langdetect.LanguageDetector;
import com.optimaize.langdetect.LanguageDetectorBuilder;
import com.optimaize.langdetect.i18n.LdLocale;
import com.optimaize.langdetect.ngram.NgramExtractors;
import com.optimaize.langdetect.profiles.LanguageProfile;
import com.optimaize.langdetect.profiles.LanguageProfileReader;
import com.optimaize.langdetect.text.CommonTextObjectFactories;
import com.optimaize.langdetect.text.TextObject;
import com.optimaize.langdetect.text.TextObjectFactory;
import com.tmxbase.dcsserver.base.constants.SpiderConstants;
import com.tmxbase.utils.ExceptionUtil;
import org.assertj.core.util.Strings;

import java.io.IOException;
import java.util.List;

/**
 * @Designation:
 * @Author: Ylz
 * @Date: 2019/11/1
 * @Version: 1.0
 */
public class LangUtil {

    private LangUtil() {
    }

    private static List<LanguageProfile> languageProfiles;
    private static LanguageDetector languageDetector;
    private static TextObjectFactory textObjectFactory;

    static {
        init();
    }

    public static void init() {
        try {
            languageProfiles = new LanguageProfileReader().readAllBuiltIn();
        } catch (IOException e) {
            ExceptionUtil.caught(e, "获取语言失败");
        }
        languageDetector = LanguageDetectorBuilder.create(NgramExtractors.standard())
                .withProfiles(languageProfiles)
                .build();
        //createExtractor a text object instance
        textObjectFactory = CommonTextObjectFactories.forDetectingOnLargeText();
    }

    public static String guessLan(String text) {
        TextObject textObject = textObjectFactory.forText(text);
        Optional<LdLocale> lang = languageDetector.detect(textObject);
        return lang.isPresent() == false ? null : lang.get().toString();
    }

    public static String guessLan(String text, String url, String domain) {
        String lan = SpiderConstants.getLan(url);
        if (!Strings.isNullOrEmpty(lan)) {
            return lan;
        }
        try {
            lan = LangUtil.guessLan(text);
            if (lan.contains("-")) {
                lan.substring(text.indexOf("-") + 1).toLowerCase();
            }
        } catch (Exception e) {
            lan = SpiderConstants.getLan(domain);
        }
        return lan;
    }


}
