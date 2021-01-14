package com.tmxbase.dcsserver.service;

import com.alibaba.fastjson.JSON;
import com.tmxbase.dcsserver.base.constants.SpiderConstants;
import com.tmxbase.dcsserver.base.model.CrawlerSource;
import com.tmxbase.dcsserver.base.model.SiteSource;
import com.tmxbase.dcsserver.base.model.mapper.SiteSourceHelper;
import com.tmxbase.dcsserver.dal.dao.CrawlerSourceSiteDAO;
import com.tmxbase.dcsserver.dal.entity.CrawlerSourceSiteDo;
import com.tmxbase.dcsserver.mq.consumer.QueueConsumer;
import com.tmxbase.dcsserver.mq.producer.QueueProducer;
import com.tmxbase.dcsserver.util.DscUtil;
import com.tmxbase.utils.AssertUtil;
import com.tmxbase.utils.DateUtil;
import com.tmxbase.utils.LoggerUtil;
import com.tmxbase.utils.StringUtil;
import com.tmxbase.utils.exception.TBException;
import com.tmxbase.utils.exception.code.SystemErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("dcsProcess")
public class DCSProcess {

    private static final Logger logger = LoggerFactory.getLogger(DCSProcess.class);

    @Autowired
    private CrawlerSourceSiteDAO crawlerSourceSiteDAO;
    @Autowired
    private QueueProducer queueProducer;
    @Autowired
    private QueueConsumer queueConsumer;
    @Autowired
    private CrawlerProcess crawlerProcess;

    public void insertSiteSource(SiteSource siteSource) {
        CrawlerSourceSiteDo crawlerSourceSiteDo = crawlerSourceSiteDAO.getDefault();
        crawlerSourceSiteDo = SiteSourceHelper.INSTANCE.transforInsert(crawlerSourceSiteDo, siteSource);
        crawlerSourceSiteDo.setfSourceSiteId(DscUtil.generateSourceSiteId());
        crawlerSourceSiteDo.setfMedia(crawlerSourceSiteDo.getfSourceSiteName());
        crawlerSourceSiteDAO.insert(crawlerSourceSiteDo);

    }

    public void updateSiteSource(SiteSource siteSource, String id) {
        CrawlerSourceSiteDo crawlerSourceSiteDo = crawlerSourceSiteDAO.loadBySourceSiteId(id);
        if (crawlerSourceSiteDo != null) {
            crawlerSourceSiteDo = SiteSourceHelper.INSTANCE.transforUpdate(crawlerSourceSiteDo, siteSource);
            crawlerSourceSiteDAO.update(crawlerSourceSiteDo, id);
        }
    }

    public void deleteSiteSource(String siteSourceId) {
        crawlerSourceSiteDAO.delete(siteSourceId);
    }

    public List<SiteSource> getSiteSource(String id) {
        List<CrawlerSourceSiteDo> crawlerSourceSiteDoList = new ArrayList<>();
        if (StringUtil.isNotBlank(id)) {
            CrawlerSourceSiteDo crawlerSourceSiteDo = crawlerSourceSiteDAO.loadBySourceSiteId(id);
            if (crawlerSourceSiteDo != null) {
                crawlerSourceSiteDoList.add(crawlerSourceSiteDo);
            }
        } else {
            crawlerSourceSiteDoList = crawlerSourceSiteDAO.loadAll();
        }
        return SiteSourceHelper.INSTANCE.transfor(crawlerSourceSiteDoList);
    }

    public void startCrawlerTask() throws Exception {
        List<CrawlerSourceSiteDo> crawlerSourceSiteDoList = crawlerSourceSiteDAO.getCrawlAble();
        if (CollectionUtils.isEmpty(crawlerSourceSiteDoList)) {
            LoggerUtil.info(logger, "[startCrawlerTask] 没有满足爬取要求的网站");
            return;
        }

        for (CrawlerSourceSiteDo crawlerSourceSiteDo : crawlerSourceSiteDoList) {
            if (StringUtil.isBlank(crawlerSourceSiteDo.getfParser())) {
                continue;
            }
            publishCrawlerTask(crawlerSourceSiteDo);
        }
    }


    public void stopSiteSource(String id) {
        CrawlerSourceSiteDo crawlerSourceSiteDo = crawlerSourceSiteDAO.loadBySourceSiteId(id);
        if (crawlerSourceSiteDo != null) {
            crawlerSourceSiteDo.setfModifyTime(new Date());
            crawlerSourceSiteDo.setfCrawlerStatus(SpiderConstants.CRAWL_STATUS_STOP);
            crawlerSourceSiteDAO.update(crawlerSourceSiteDo, id);
        }
    }

    public void publishCrawlerTask(CrawlerSourceSiteDo crawlerSourceSiteDo) throws Exception {
        publishCrawlerTask(SiteSourceHelper.INSTANCE.transfor(crawlerSourceSiteDo));
        LoggerUtil.info(logger, "[startCrawlerTask] 爬取完毕: " + crawlerSourceSiteDo);

//        // 数据修改为爬取中
//        crawlerSourceSiteDo.setfCrawlerStatus(SpiderConstants.CRAWL_STATUS_CRAWLING);
//        crawlerSourceSiteDAO.update(crawlerSourceSiteDo, crawlerSourceSiteDo.getfSourceSiteId());
    }

    public void publishCrawlerTask(SiteSource siteSource) throws Exception {
        // 发布爬取任务
        AssertUtil.isNotNull(siteSource, SystemErrorCode.INVALID_RESOURCE);
        receiveCrawlerQueue(JSON.toJSONString(siteSource));
    }

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
