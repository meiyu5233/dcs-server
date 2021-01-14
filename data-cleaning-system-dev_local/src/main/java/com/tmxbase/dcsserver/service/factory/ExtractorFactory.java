package com.tmxbase.dcsserver.service.factory;

import com.tmxbase.dcsserver.base.constants.SpiderConstants;
import com.tmxbase.dcsserver.service.NewsExtractor;
import com.tmxbase.utils.StringUtil;
import org.springframework.stereotype.Component;

@Component
public class ExtractorFactory {

    public static final String EXTRACTOR_NEWS = SpiderConstants.EXTRACTOR_NEWS;

    public static HtmlExtractor createExtractor(String type) {
        if (StringUtil.equals(type, EXTRACTOR_NEWS)) {
            return NewsExtractor.getInstance();
        } else {
            return null;
        }
    }
}
