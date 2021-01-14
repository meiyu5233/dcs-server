package com.tmxbase.dcsserver.mq.producer;

import com.alibaba.fastjson.JSON;
import com.tmxbase.dcsserver.base.model.CrawlerSource;
import com.tmxbase.dcsserver.base.model.SiteSource;
import com.tmxbase.dcsserver.mq.consumer.QueueConsumer;
import com.tmxbase.utils.AssertUtil;
import com.tmxbase.utils.LoggerUtil;
import com.tmxbase.utils.exception.code.SystemErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class QueueProducer {
    private static final Logger logger = LoggerFactory.getLogger(QueueProducer.class);

    @Autowired
    private QueueConsumer queueConsumer;

    public void publishCrawlerTask(SiteSource siteSource) throws Exception {
        // 发布爬取任务
        AssertUtil.isNotNull(siteSource, SystemErrorCode.INVALID_RESOURCE);
        queueConsumer.receiveCrawlerQueue(JSON.toJSONString(siteSource));
    }

    public void publishCrawlerSourceProcessTask(CrawlerSource crawlerSource) throws IOException {
        AssertUtil.isNotNull(crawlerSource, SystemErrorCode.INVALID_RESOURCE);
        LoggerUtil.info(logger, "[publishCrawlerSourceProcessTask]开始执行" + crawlerSource.getParser() + crawlerSource.getCrawlerFilePath());
        queueConsumer.receiveCrawlerSourceProcessQueue(JSON.toJSONString(crawlerSource));
    }


}
