package com.tmxbase.dcsserver.service.factory;

import java.util.Date;
import java.util.List;

public interface HtmlExtractor {

    public String getTitle(String htmlString);

    public String getText(String htmlString, String contentTag, List<String> noiseNodeList);

    public Date getTime(String htmlString, String contentTag);
}
