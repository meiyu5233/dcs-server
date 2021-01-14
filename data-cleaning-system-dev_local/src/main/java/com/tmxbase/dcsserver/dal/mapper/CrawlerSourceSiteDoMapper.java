package com.tmxbase.dcsserver.dal.mapper;

import com.tmxbase.dcsserver.dal.entity.CrawlerSourceSiteDo;
import com.tmxbase.dcsserver.dal.entity.CrawlerSourceSiteDoExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CrawlerSourceSiteDoMapper {
    long countByExample(CrawlerSourceSiteDoExample example);

    int deleteByExample(CrawlerSourceSiteDoExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(CrawlerSourceSiteDo record);

    int insertSelective(CrawlerSourceSiteDo record);

    List<CrawlerSourceSiteDo> selectByExampleWithRowbounds(CrawlerSourceSiteDoExample example, RowBounds rowBounds);

    List<CrawlerSourceSiteDo> selectByExample(CrawlerSourceSiteDoExample example);

    CrawlerSourceSiteDo selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") CrawlerSourceSiteDo record, @Param("example") CrawlerSourceSiteDoExample example);

    int updateByExample(@Param("record") CrawlerSourceSiteDo record, @Param("example") CrawlerSourceSiteDoExample example);

    int updateByPrimaryKeySelective(CrawlerSourceSiteDo record);

    int updateByPrimaryKey(CrawlerSourceSiteDo record);
}