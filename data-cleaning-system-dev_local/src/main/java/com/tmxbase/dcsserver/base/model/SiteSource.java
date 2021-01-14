package com.tmxbase.dcsserver.base.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SiteSource {

    private String siteSourceId;
    private String siteSourceName;
    private String siteSourceUri;
    private byte status;
    private byte siteEnabled;
    private String lan;
    private String country;
    private String source;
    private String platform;
    private String parser;
    private Date createTime;
    private Date modifyTime;
    private Date lastCrawlTime;
    private Date nextCrawlTime;
    private int crawlInterval;
    private int crawlDepth;
    private byte useProxy;
    private String media;
    private int crawlThreads;
}
