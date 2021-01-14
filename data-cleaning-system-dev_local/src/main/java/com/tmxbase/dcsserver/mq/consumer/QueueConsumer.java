package com.tmxbase.dcsserver.mq.consumer;

import com.alibaba.fastjson.JSON;
import com.tmxbase.dcsserver.base.constants.SpiderConstants;
import com.tmxbase.dcsserver.base.model.CrawlerSource;
import com.tmxbase.dcsserver.base.model.SiteSource;
import com.tmxbase.dcsserver.dal.dao.CrawlerSourceSiteDAO;
import com.tmxbase.dcsserver.dal.entity.CrawlerSourceSiteDo;
import com.tmxbase.dcsserver.service.CrawlerProcess;
import com.tmxbase.utils.DateUtil;
import com.tmxbase.utils.LoggerUtil;
import com.tmxbase.utils.StringUtil;
import com.tmxbase.utils.exception.TBException;
import com.tmxbase.utils.exception.code.SystemErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

@Service
public class QueueConsumer {

    private static final Logger logger = LoggerFactory.getLogger(QueueConsumer.class);

    @Autowired
    private CrawlerProcess crawlerProcess;
    @Autowired
    private CrawlerSourceSiteDAO crawlerSourceSiteDAO;

    public void receiveCrawlerQueue(String siteSourceStr) throws Exception {
        LoggerUtil.info(logger, "[receiveCrawlerQueue] siteSourceStr:" + siteSourceStr);
        SiteSource siteSource = JSON.parseObject(siteSourceStr, SiteSource.class);
        try {
            crawlerProcess.webCollector(siteSource);
        } catch (Exception e) {
            LoggerUtil.error(logger, new TBException(SystemErrorCode.INVALID_OPERATION), "[receiveCrawlerQueue] 爬虫出现错误停止");
            updateCrawlerSourceStatusUnstart(siteSource.getSiteSourceId());
        }
    }

    public void receiveCrawlerSourceProcessQueue(String crawlerSourceString) throws IOException {
        LoggerUtil.info(logger, "[receiveCrawlerSourceProcessQueue] crawlerSourceString:" + crawlerSourceString);
        CrawlerSource crawlerSource = JSON.parseObject(crawlerSourceString, CrawlerSource.class);
        if (StringUtil.isNotBlank(crawlerSource.getCrawlerFilePath())) {
            crawlerProcess.crawlerSourceProcess(crawlerSource);
        } else {
            LoggerUtil.error(logger, new TBException(SystemErrorCode.INVALID_OPERATION), "[receiveCrawlerSourceProcessQueue] 路径为空，没有要爬取的数据");
        }
        // 任务完成修改状态
        updateCrawlerSourceStatusUnstart(crawlerSource.getSiteSourceId());
    }

    public void updateCrawlerSourceStatusUnstart(String siteSourceId) {
        Date now = new Date();
        CrawlerSourceSiteDo crawlerSourceSiteDo = crawlerSourceSiteDAO.loadBySourceSiteId(siteSourceId);
        if (crawlerSourceSiteDo != null) {
            crawlerSourceSiteDo.setfCrawlerStatus(SpiderConstants.CRAWL_STATUS_UNSTART);
            crawlerSourceSiteDo.setfLastCrawlTime(now);
            crawlerSourceSiteDo.setfNextCrawlTime(DateUtil.getNDaysAfterTime(now, crawlerSourceSiteDo.getfCrawlInterval()));
            crawlerSourceSiteDAO.update(crawlerSourceSiteDo, siteSourceId);
        }
    }
}
