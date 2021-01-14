package com.tmxbase.dcsserver.service.process;

import com.tmxbase.dcsserver.util.UTF8Util;
import com.tmxbase.utils.LoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("nlpAnalysisProcess")
public class NLPAnalysisProcess {

    private static final Logger logger = LoggerFactory.getLogger(NLPAnalysisProcess.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${nlp.analysis.host}")
    private String nlpAnalysisHost;

    public String evaluateSentiment(String content) {
        LoggerUtil.info(logger, "content编码为" + UTF8Util.getEncoding(content));
        content = UTF8Util.toUTF8(content);
        LoggerUtil.info(logger, "content编码为" + UTF8Util.getEncoding(content));
        String responseEntity = restTemplate.postForObject(nlpAnalysisHost + "/sentiment", content, String.class);
        return restTemplate.postForObject(nlpAnalysisHost + "/sentiment", content, String.class);
    }

    public String evaluateSummary(List<String> contentList) {
        return unicodeToString(restTemplate.postForObject(nlpAnalysisHost + "/summary", contentList, String.class));
    }

    public String evaluateIndustry(String content) {
        return restTemplate.postForObject(nlpAnalysisHost + "/topic", content, String.class);
    }

    public String unicodeToString(String unicode) {
        if (unicode == null || "".equals(unicode)) {
            return null;
        }
        unicode = unicode.substring(1, unicode.length() - 1);
        StringBuilder sb = new StringBuilder();
        int i = -1;
        int pos = 0;
        if (unicode.indexOf("\\u", pos) == -1) {
            return unicode;
        }
        while ((i = unicode.indexOf("\\u", pos)) != -1) {
            sb.append(unicode.substring(pos, i));
            if (i + 5 < unicode.length()) {
                pos = i + 6;
                sb.append((char) Integer.parseInt(unicode.substring(i + 2, i + 6), 16));
            }
        }
        return sb.toString();
    }
}
