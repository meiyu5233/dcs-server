package com.tmxbase.dcsserver.base.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrawlerSource {

    public CrawlerSource(String siteSourceName) {
    }

    private String siteSourceId;

    private String siteSourceName;

    private String siteSourceUri;

    private String lan;

    private String country;

    private String source;

    private String platform;

    private String parser;

    private String crawlerFilePath;

    private String media;
}
