package com.tmxbase.dcsserver.dal.entity;

import java.io.Serializable;
import java.util.Date;

public class CrawlerSourceSiteDo implements Serializable {
    private Integer fId;

    private Byte fEnabled;

    private String fSourceSiteId;

    private String fSourceSiteName;

    private String fSourceSiteUri;

    private Byte fCrawlerStatus;

    private Byte fCrawlerEnabled;

    private Byte fUseProxy;

    private Integer fCrawlDepth;

    private String fLan;

    private String fCountry;

    private String fSourceCategory;

    private String fPlatformCategory;

    private String fMedia;

    private String fParser;

    private Date fCreateTime;

    private Date fModifyTime;

    private Date fLastCrawlTime;

    private Date fNextCrawlTime;

    private Integer fCrawlInterval;

    private Integer fCrawlThreads;

    private static final long serialVersionUID = 1L;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public Byte getfEnabled() {
        return fEnabled;
    }

    public void setfEnabled(Byte fEnabled) {
        this.fEnabled = fEnabled;
    }

    public String getfSourceSiteId() {
        return fSourceSiteId;
    }

    public void setfSourceSiteId(String fSourceSiteId) {
        this.fSourceSiteId = fSourceSiteId == null ? null : fSourceSiteId.trim();
    }

    public String getfSourceSiteName() {
        return fSourceSiteName;
    }

    public void setfSourceSiteName(String fSourceSiteName) {
        this.fSourceSiteName = fSourceSiteName == null ? null : fSourceSiteName.trim();
    }

    public String getfSourceSiteUri() {
        return fSourceSiteUri;
    }

    public void setfSourceSiteUri(String fSourceSiteUri) {
        this.fSourceSiteUri = fSourceSiteUri == null ? null : fSourceSiteUri.trim();
    }

    public Byte getfCrawlerStatus() {
        return fCrawlerStatus;
    }

    public void setfCrawlerStatus(Byte fCrawlerStatus) {
        this.fCrawlerStatus = fCrawlerStatus;
    }

    public Byte getfCrawlerEnabled() {
        return fCrawlerEnabled;
    }

    public void setfCrawlerEnabled(Byte fCrawlerEnabled) {
        this.fCrawlerEnabled = fCrawlerEnabled;
    }

    public Byte getfUseProxy() {
        return fUseProxy;
    }

    public void setfUseProxy(Byte fUseProxy) {
        this.fUseProxy = fUseProxy;
    }

    public Integer getfCrawlDepth() {
        return fCrawlDepth;
    }

    public void setfCrawlDepth(Integer fCrawlDepth) {
        this.fCrawlDepth = fCrawlDepth;
    }

    public String getfLan() {
        return fLan;
    }

    public void setfLan(String fLan) {
        this.fLan = fLan == null ? null : fLan.trim();
    }

    public String getfCountry() {
        return fCountry;
    }

    public void setfCountry(String fCountry) {
        this.fCountry = fCountry == null ? null : fCountry.trim();
    }

    public String getfSourceCategory() {
        return fSourceCategory;
    }

    public void setfSourceCategory(String fSourceCategory) {
        this.fSourceCategory = fSourceCategory == null ? null : fSourceCategory.trim();
    }

    public String getfPlatformCategory() {
        return fPlatformCategory;
    }

    public void setfPlatformCategory(String fPlatformCategory) {
        this.fPlatformCategory = fPlatformCategory == null ? null : fPlatformCategory.trim();
    }

    public String getfMedia() {
        return fMedia;
    }

    public void setfMedia(String fMedia) {
        this.fMedia = fMedia == null ? null : fMedia.trim();
    }

    public String getfParser() {
        return fParser;
    }

    public void setfParser(String fParser) {
        this.fParser = fParser == null ? null : fParser.trim();
    }

    public Date getfCreateTime() {
        return fCreateTime;
    }

    public void setfCreateTime(Date fCreateTime) {
        this.fCreateTime = fCreateTime;
    }

    public Date getfModifyTime() {
        return fModifyTime;
    }

    public void setfModifyTime(Date fModifyTime) {
        this.fModifyTime = fModifyTime;
    }

    public Date getfLastCrawlTime() {
        return fLastCrawlTime;
    }

    public void setfLastCrawlTime(Date fLastCrawlTime) {
        this.fLastCrawlTime = fLastCrawlTime;
    }

    public Date getfNextCrawlTime() {
        return fNextCrawlTime;
    }

    public void setfNextCrawlTime(Date fNextCrawlTime) {
        this.fNextCrawlTime = fNextCrawlTime;
    }

    public Integer getfCrawlInterval() {
        return fCrawlInterval;
    }

    public void setfCrawlInterval(Integer fCrawlInterval) {
        this.fCrawlInterval = fCrawlInterval;
    }

    public Integer getfCrawlThreads() {
        return fCrawlThreads;
    }

    public void setfCrawlThreads(Integer fCrawlThreads) {
        this.fCrawlThreads = fCrawlThreads;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fId=").append(fId);
        sb.append(", fEnabled=").append(fEnabled);
        sb.append(", fSourceSiteId=").append(fSourceSiteId);
        sb.append(", fSourceSiteName=").append(fSourceSiteName);
        sb.append(", fSourceSiteUri=").append(fSourceSiteUri);
        sb.append(", fCrawlerStatus=").append(fCrawlerStatus);
        sb.append(", fCrawlerEnabled=").append(fCrawlerEnabled);
        sb.append(", fUseProxy=").append(fUseProxy);
        sb.append(", fCrawlDepth=").append(fCrawlDepth);
        sb.append(", fLan=").append(fLan);
        sb.append(", fCountry=").append(fCountry);
        sb.append(", fSourceCategory=").append(fSourceCategory);
        sb.append(", fPlatformCategory=").append(fPlatformCategory);
        sb.append(", fMedia=").append(fMedia);
        sb.append(", fParser=").append(fParser);
        sb.append(", fCreateTime=").append(fCreateTime);
        sb.append(", fModifyTime=").append(fModifyTime);
        sb.append(", fLastCrawlTime=").append(fLastCrawlTime);
        sb.append(", fNextCrawlTime=").append(fNextCrawlTime);
        sb.append(", fCrawlInterval=").append(fCrawlInterval);
        sb.append(", fCrawlThreads=").append(fCrawlThreads);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}