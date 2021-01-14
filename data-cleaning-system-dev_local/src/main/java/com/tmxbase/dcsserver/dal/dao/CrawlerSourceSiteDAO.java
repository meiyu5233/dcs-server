package com.tmxbase.dcsserver.dal.dao;

import com.tmxbase.dcsserver.base.constants.SpiderConstants;
import com.tmxbase.dcsserver.dal.entity.CrawlerSourceSiteDo;
import com.tmxbase.dcsserver.dal.entity.CrawlerSourceSiteDoExample;
import com.tmxbase.dcsserver.dal.mapper.CrawlerSourceSiteDoMapper;
import org.nlpcn.commons.lang.util.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

@Repository("crawlerSourceSiteDAO")
public class CrawlerSourceSiteDAO {

    @Autowired
    private CrawlerSourceSiteDoMapper crawlerSourceSiteDoMapper;

    public CrawlerSourceSiteDo getDefault() {
        Date date = new Date();
        CrawlerSourceSiteDo crawlerSourceSiteDo = new CrawlerSourceSiteDo();
        crawlerSourceSiteDo.setfEnabled((byte) 1);
        crawlerSourceSiteDo.setfSourceSiteId("");
        crawlerSourceSiteDo.setfSourceSiteName("");
        crawlerSourceSiteDo.setfSourceSiteUri("");
        crawlerSourceSiteDo.setfCrawlerStatus(SpiderConstants.CRAWL_STATUS_UNSTART);
        crawlerSourceSiteDo.setfCrawlerEnabled((byte) 0);
        crawlerSourceSiteDo.setfUseProxy((byte) 0);
        crawlerSourceSiteDo.setfCrawlDepth(0);
        crawlerSourceSiteDo.setfLan("");
        crawlerSourceSiteDo.setfCountry("");
        crawlerSourceSiteDo.setfSourceCategory("");
        crawlerSourceSiteDo.setfPlatformCategory("");
        crawlerSourceSiteDo.setfMedia("");
        crawlerSourceSiteDo.setfParser("");
        crawlerSourceSiteDo.setfCreateTime(date);
        crawlerSourceSiteDo.setfModifyTime(date);
        crawlerSourceSiteDo.setfLastCrawlTime(null);
        crawlerSourceSiteDo.setfNextCrawlTime(null);
        crawlerSourceSiteDo.setfCrawlInterval(0);
        crawlerSourceSiteDo.setfCrawlThreads(0);

        return crawlerSourceSiteDo;
    }

    public void insert(CrawlerSourceSiteDo crawlerSourceSiteDo) {
        crawlerSourceSiteDoMapper.insert(crawlerSourceSiteDo);
    }

    public List<CrawlerSourceSiteDo> getCrawlAble() {
        Date now = new Date();
        CrawlerSourceSiteDoExample example = new CrawlerSourceSiteDoExample();
        CrawlerSourceSiteDoExample.Criteria criteria = example.createCriteria();
        criteria.andFEnabledEqualTo((byte) 1); //
        criteria.andFCrawlerEnabledEqualTo((byte) 1);  // 启用的爬虫
        criteria.andFCrawlerStatusEqualTo(SpiderConstants.CRAWL_STATUS_UNSTART);   // 非进行中爬虫
        criteria.andFNextCrawlTimeLessThanOrEqualTo(now); // 满足爬取时间
        return crawlerSourceSiteDoMapper.selectByExample(example);
    }

    public void update(CrawlerSourceSiteDo crawlerSourceSiteDo, String crawlerSourceSiteId) {
        crawlerSourceSiteDo.setfModifyTime(new Date());
        CrawlerSourceSiteDoExample example = new CrawlerSourceSiteDoExample();
        CrawlerSourceSiteDoExample.Criteria criteria = example.createCriteria();
        criteria.andFEnabledEqualTo((byte) 1); //
        criteria.andFSourceSiteIdEqualTo(crawlerSourceSiteId);
        crawlerSourceSiteDoMapper.updateByExampleSelective(crawlerSourceSiteDo, example);
    }

    public void delete(String crawlerSourceSiteId) {
        CrawlerSourceSiteDoExample example = new CrawlerSourceSiteDoExample();
        CrawlerSourceSiteDoExample.Criteria criteria = example.createCriteria();
        criteria.andFEnabledEqualTo((byte) 1); //
        criteria.andFSourceSiteIdEqualTo(crawlerSourceSiteId);
        crawlerSourceSiteDoMapper.deleteByExample(example);
    }

    public List<CrawlerSourceSiteDo> loadAll() {
        CrawlerSourceSiteDoExample example = new CrawlerSourceSiteDoExample();
        return crawlerSourceSiteDoMapper.selectByExample(example);
    }

    public CrawlerSourceSiteDo loadBySourceSiteId(String sourceSiteId) {
        CrawlerSourceSiteDoExample example = new CrawlerSourceSiteDoExample();
        CrawlerSourceSiteDoExample.Criteria criteria = example.createCriteria();
        criteria.andFSourceSiteIdEqualTo(sourceSiteId);
        List<CrawlerSourceSiteDo> crawlerSourceSiteDoList = crawlerSourceSiteDoMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(crawlerSourceSiteDoList)) {
            return crawlerSourceSiteDoList.get(0);
        }
        return null;
    }
}
