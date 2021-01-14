package com.tmxbase.dcsserver.base.model.mapper;

import com.tmxbase.dcsserver.base.model.SiteSource;
import com.tmxbase.dcsserver.dal.entity.CrawlerSourceSiteDo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SiteSourceHelper {

    SiteSourceHelper INSTANCE = Mappers.getMapper(SiteSourceHelper.class);

    @Mapping(source = "fSourceSiteId", target = "siteSourceId")
    @Mapping(source = "fSourceSiteName", target = "siteSourceName")
    @Mapping(source = "fSourceSiteUri", target = "siteSourceUri")
    @Mapping(source = "fCrawlerStatus", target = "status")
    @Mapping(source = "fCrawlerEnabled", target = "siteEnabled")
    @Mapping(source = "fUseProxy", target = "useProxy")
    @Mapping(source = "fCrawlDepth", target = "crawlDepth")
    @Mapping(source = "fLan", target = "lan")
    @Mapping(source = "fCountry", target = "country")
    @Mapping(source = "fSourceCategory", target = "source")
    @Mapping(source = "fPlatformCategory", target = "platform")
    @Mapping(source = "fMedia", target = "media")
    @Mapping(source = "fParser", target = "parser")
    @Mapping(source = "fCreateTime", target = "createTime")
    @Mapping(source = "fModifyTime", target = "modifyTime")
    @Mapping(source = "fLastCrawlTime", target = "lastCrawlTime")
    @Mapping(source = "fNextCrawlTime", target = "nextCrawlTime")
    @Mapping(source = "fCrawlInterval", target = "crawlInterval")
    @Mapping(source = "fCrawlThreads", target = "crawlThreads")
    SiteSource transfor(CrawlerSourceSiteDo sourceSiteDo);

    List<SiteSource> transfor(List<CrawlerSourceSiteDo> sourceSiteDoList);

    @Mapping(source = "siteSource.siteSourceName", target = "fSourceSiteName")
    @Mapping(source = "siteSource.siteSourceUri", target = "fSourceSiteUri")
    @Mapping(source = "siteSource.status", target = "fCrawlerStatus")
    @Mapping(source = "siteSource.siteEnabled", target = "fCrawlerEnabled")
    @Mapping(source = "siteSource.lan", target = "fLan")
    @Mapping(source = "siteSource.country", target = "fCountry")
    @Mapping(source = "siteSource.source", target = "fSourceCategory")
    @Mapping(source = "siteSource.platform", target = "fPlatformCategory")
    @Mapping(source = "siteSource.parser", target = "fParser")
    @Mapping(source = "siteSource.crawlInterval", target = "fCrawlInterval")
    @Mapping(source = "siteSource.crawlDepth", target = "fCrawlDepth")
    @Mapping(source = "siteSource.useProxy", target = "fUseProxy")
    @Mapping(source = "siteSource.media", target = "fMedia")
    @Mapping(source = "siteSource.crawlThreads", target = "fCrawlThreads")
    @Mapping(source = "siteSource.nextCrawlTime", target = "fNextCrawlTime")
    CrawlerSourceSiteDo transforInsert(@MappingTarget CrawlerSourceSiteDo sourceSiteDo, SiteSource siteSource);

    @Mapping(source = "siteSource.siteSourceName", target = "fSourceSiteName")
    @Mapping(source = "siteSource.siteSourceUri", target = "fSourceSiteUri")
    @Mapping(source = "siteSource.status", target = "fCrawlerStatus")
    @Mapping(source = "siteSource.siteEnabled", target = "fCrawlerEnabled")
    @Mapping(source = "siteSource.lan", target = "fLan")
    @Mapping(source = "siteSource.country", target = "fCountry")
    @Mapping(source = "siteSource.source", target = "fSourceCategory")
    @Mapping(source = "siteSource.platform", target = "fPlatformCategory")
    @Mapping(source = "siteSource.parser", target = "fParser")
    @Mapping(source = "siteSource.lastCrawlTime", target = "fLastCrawlTime")
    @Mapping(source = "siteSource.nextCrawlTime", target = "fNextCrawlTime")
    @Mapping(source = "siteSource.crawlInterval", target = "fCrawlInterval")
    @Mapping(source = "siteSource.crawlDepth", target = "fCrawlDepth")
    @Mapping(source = "siteSource.useProxy", target = "fUseProxy")
    @Mapping(source = "siteSource.media", target = "fMedia")
    @Mapping(source = "siteSource.crawlThreads", target = "fCrawlThreads")
    CrawlerSourceSiteDo transforUpdate(@MappingTarget CrawlerSourceSiteDo sourceSiteDo, SiteSource siteSource);
}
