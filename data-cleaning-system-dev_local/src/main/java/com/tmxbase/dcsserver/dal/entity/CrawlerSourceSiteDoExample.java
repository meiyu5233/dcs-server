package com.tmxbase.dcsserver.dal.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CrawlerSourceSiteDoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CrawlerSourceSiteDoExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andFIdIsNull() {
            addCriterion("F_id is null");
            return (Criteria) this;
        }

        public Criteria andFIdIsNotNull() {
            addCriterion("F_id is not null");
            return (Criteria) this;
        }

        public Criteria andFIdEqualTo(Integer value) {
            addCriterion("F_id =", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdNotEqualTo(Integer value) {
            addCriterion("F_id <>", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdGreaterThan(Integer value) {
            addCriterion("F_id >", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("F_id >=", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdLessThan(Integer value) {
            addCriterion("F_id <", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdLessThanOrEqualTo(Integer value) {
            addCriterion("F_id <=", value, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdIn(List<Integer> values) {
            addCriterion("F_id in", values, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdNotIn(List<Integer> values) {
            addCriterion("F_id not in", values, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdBetween(Integer value1, Integer value2) {
            addCriterion("F_id between", value1, value2, "fId");
            return (Criteria) this;
        }

        public Criteria andFIdNotBetween(Integer value1, Integer value2) {
            addCriterion("F_id not between", value1, value2, "fId");
            return (Criteria) this;
        }

        public Criteria andFEnabledIsNull() {
            addCriterion("F_enabled is null");
            return (Criteria) this;
        }

        public Criteria andFEnabledIsNotNull() {
            addCriterion("F_enabled is not null");
            return (Criteria) this;
        }

        public Criteria andFEnabledEqualTo(Byte value) {
            addCriterion("F_enabled =", value, "fEnabled");
            return (Criteria) this;
        }

        public Criteria andFEnabledNotEqualTo(Byte value) {
            addCriterion("F_enabled <>", value, "fEnabled");
            return (Criteria) this;
        }

        public Criteria andFEnabledGreaterThan(Byte value) {
            addCriterion("F_enabled >", value, "fEnabled");
            return (Criteria) this;
        }

        public Criteria andFEnabledGreaterThanOrEqualTo(Byte value) {
            addCriterion("F_enabled >=", value, "fEnabled");
            return (Criteria) this;
        }

        public Criteria andFEnabledLessThan(Byte value) {
            addCriterion("F_enabled <", value, "fEnabled");
            return (Criteria) this;
        }

        public Criteria andFEnabledLessThanOrEqualTo(Byte value) {
            addCriterion("F_enabled <=", value, "fEnabled");
            return (Criteria) this;
        }

        public Criteria andFEnabledIn(List<Byte> values) {
            addCriterion("F_enabled in", values, "fEnabled");
            return (Criteria) this;
        }

        public Criteria andFEnabledNotIn(List<Byte> values) {
            addCriterion("F_enabled not in", values, "fEnabled");
            return (Criteria) this;
        }

        public Criteria andFEnabledBetween(Byte value1, Byte value2) {
            addCriterion("F_enabled between", value1, value2, "fEnabled");
            return (Criteria) this;
        }

        public Criteria andFEnabledNotBetween(Byte value1, Byte value2) {
            addCriterion("F_enabled not between", value1, value2, "fEnabled");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteIdIsNull() {
            addCriterion("F_source_site_id is null");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteIdIsNotNull() {
            addCriterion("F_source_site_id is not null");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteIdEqualTo(String value) {
            addCriterion("F_source_site_id =", value, "fSourceSiteId");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteIdNotEqualTo(String value) {
            addCriterion("F_source_site_id <>", value, "fSourceSiteId");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteIdGreaterThan(String value) {
            addCriterion("F_source_site_id >", value, "fSourceSiteId");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteIdGreaterThanOrEqualTo(String value) {
            addCriterion("F_source_site_id >=", value, "fSourceSiteId");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteIdLessThan(String value) {
            addCriterion("F_source_site_id <", value, "fSourceSiteId");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteIdLessThanOrEqualTo(String value) {
            addCriterion("F_source_site_id <=", value, "fSourceSiteId");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteIdLike(String value) {
            addCriterion("F_source_site_id like", value, "fSourceSiteId");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteIdNotLike(String value) {
            addCriterion("F_source_site_id not like", value, "fSourceSiteId");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteIdIn(List<String> values) {
            addCriterion("F_source_site_id in", values, "fSourceSiteId");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteIdNotIn(List<String> values) {
            addCriterion("F_source_site_id not in", values, "fSourceSiteId");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteIdBetween(String value1, String value2) {
            addCriterion("F_source_site_id between", value1, value2, "fSourceSiteId");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteIdNotBetween(String value1, String value2) {
            addCriterion("F_source_site_id not between", value1, value2, "fSourceSiteId");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteNameIsNull() {
            addCriterion("F_source_site_name is null");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteNameIsNotNull() {
            addCriterion("F_source_site_name is not null");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteNameEqualTo(String value) {
            addCriterion("F_source_site_name =", value, "fSourceSiteName");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteNameNotEqualTo(String value) {
            addCriterion("F_source_site_name <>", value, "fSourceSiteName");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteNameGreaterThan(String value) {
            addCriterion("F_source_site_name >", value, "fSourceSiteName");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteNameGreaterThanOrEqualTo(String value) {
            addCriterion("F_source_site_name >=", value, "fSourceSiteName");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteNameLessThan(String value) {
            addCriterion("F_source_site_name <", value, "fSourceSiteName");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteNameLessThanOrEqualTo(String value) {
            addCriterion("F_source_site_name <=", value, "fSourceSiteName");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteNameLike(String value) {
            addCriterion("F_source_site_name like", value, "fSourceSiteName");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteNameNotLike(String value) {
            addCriterion("F_source_site_name not like", value, "fSourceSiteName");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteNameIn(List<String> values) {
            addCriterion("F_source_site_name in", values, "fSourceSiteName");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteNameNotIn(List<String> values) {
            addCriterion("F_source_site_name not in", values, "fSourceSiteName");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteNameBetween(String value1, String value2) {
            addCriterion("F_source_site_name between", value1, value2, "fSourceSiteName");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteNameNotBetween(String value1, String value2) {
            addCriterion("F_source_site_name not between", value1, value2, "fSourceSiteName");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteUriIsNull() {
            addCriterion("F_source_site_uri is null");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteUriIsNotNull() {
            addCriterion("F_source_site_uri is not null");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteUriEqualTo(String value) {
            addCriterion("F_source_site_uri =", value, "fSourceSiteUri");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteUriNotEqualTo(String value) {
            addCriterion("F_source_site_uri <>", value, "fSourceSiteUri");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteUriGreaterThan(String value) {
            addCriterion("F_source_site_uri >", value, "fSourceSiteUri");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteUriGreaterThanOrEqualTo(String value) {
            addCriterion("F_source_site_uri >=", value, "fSourceSiteUri");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteUriLessThan(String value) {
            addCriterion("F_source_site_uri <", value, "fSourceSiteUri");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteUriLessThanOrEqualTo(String value) {
            addCriterion("F_source_site_uri <=", value, "fSourceSiteUri");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteUriLike(String value) {
            addCriterion("F_source_site_uri like", value, "fSourceSiteUri");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteUriNotLike(String value) {
            addCriterion("F_source_site_uri not like", value, "fSourceSiteUri");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteUriIn(List<String> values) {
            addCriterion("F_source_site_uri in", values, "fSourceSiteUri");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteUriNotIn(List<String> values) {
            addCriterion("F_source_site_uri not in", values, "fSourceSiteUri");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteUriBetween(String value1, String value2) {
            addCriterion("F_source_site_uri between", value1, value2, "fSourceSiteUri");
            return (Criteria) this;
        }

        public Criteria andFSourceSiteUriNotBetween(String value1, String value2) {
            addCriterion("F_source_site_uri not between", value1, value2, "fSourceSiteUri");
            return (Criteria) this;
        }

        public Criteria andFCrawlerStatusIsNull() {
            addCriterion("F_crawler_status is null");
            return (Criteria) this;
        }

        public Criteria andFCrawlerStatusIsNotNull() {
            addCriterion("F_crawler_status is not null");
            return (Criteria) this;
        }

        public Criteria andFCrawlerStatusEqualTo(Byte value) {
            addCriterion("F_crawler_status =", value, "fCrawlerStatus");
            return (Criteria) this;
        }

        public Criteria andFCrawlerStatusNotEqualTo(Byte value) {
            addCriterion("F_crawler_status <>", value, "fCrawlerStatus");
            return (Criteria) this;
        }

        public Criteria andFCrawlerStatusGreaterThan(Byte value) {
            addCriterion("F_crawler_status >", value, "fCrawlerStatus");
            return (Criteria) this;
        }

        public Criteria andFCrawlerStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("F_crawler_status >=", value, "fCrawlerStatus");
            return (Criteria) this;
        }

        public Criteria andFCrawlerStatusLessThan(Byte value) {
            addCriterion("F_crawler_status <", value, "fCrawlerStatus");
            return (Criteria) this;
        }

        public Criteria andFCrawlerStatusLessThanOrEqualTo(Byte value) {
            addCriterion("F_crawler_status <=", value, "fCrawlerStatus");
            return (Criteria) this;
        }

        public Criteria andFCrawlerStatusIn(List<Byte> values) {
            addCriterion("F_crawler_status in", values, "fCrawlerStatus");
            return (Criteria) this;
        }

        public Criteria andFCrawlerStatusNotIn(List<Byte> values) {
            addCriterion("F_crawler_status not in", values, "fCrawlerStatus");
            return (Criteria) this;
        }

        public Criteria andFCrawlerStatusBetween(Byte value1, Byte value2) {
            addCriterion("F_crawler_status between", value1, value2, "fCrawlerStatus");
            return (Criteria) this;
        }

        public Criteria andFCrawlerStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("F_crawler_status not between", value1, value2, "fCrawlerStatus");
            return (Criteria) this;
        }

        public Criteria andFCrawlerEnabledIsNull() {
            addCriterion("F_crawler_enabled is null");
            return (Criteria) this;
        }

        public Criteria andFCrawlerEnabledIsNotNull() {
            addCriterion("F_crawler_enabled is not null");
            return (Criteria) this;
        }

        public Criteria andFCrawlerEnabledEqualTo(Byte value) {
            addCriterion("F_crawler_enabled =", value, "fCrawlerEnabled");
            return (Criteria) this;
        }

        public Criteria andFCrawlerEnabledNotEqualTo(Byte value) {
            addCriterion("F_crawler_enabled <>", value, "fCrawlerEnabled");
            return (Criteria) this;
        }

        public Criteria andFCrawlerEnabledGreaterThan(Byte value) {
            addCriterion("F_crawler_enabled >", value, "fCrawlerEnabled");
            return (Criteria) this;
        }

        public Criteria andFCrawlerEnabledGreaterThanOrEqualTo(Byte value) {
            addCriterion("F_crawler_enabled >=", value, "fCrawlerEnabled");
            return (Criteria) this;
        }

        public Criteria andFCrawlerEnabledLessThan(Byte value) {
            addCriterion("F_crawler_enabled <", value, "fCrawlerEnabled");
            return (Criteria) this;
        }

        public Criteria andFCrawlerEnabledLessThanOrEqualTo(Byte value) {
            addCriterion("F_crawler_enabled <=", value, "fCrawlerEnabled");
            return (Criteria) this;
        }

        public Criteria andFCrawlerEnabledIn(List<Byte> values) {
            addCriterion("F_crawler_enabled in", values, "fCrawlerEnabled");
            return (Criteria) this;
        }

        public Criteria andFCrawlerEnabledNotIn(List<Byte> values) {
            addCriterion("F_crawler_enabled not in", values, "fCrawlerEnabled");
            return (Criteria) this;
        }

        public Criteria andFCrawlerEnabledBetween(Byte value1, Byte value2) {
            addCriterion("F_crawler_enabled between", value1, value2, "fCrawlerEnabled");
            return (Criteria) this;
        }

        public Criteria andFCrawlerEnabledNotBetween(Byte value1, Byte value2) {
            addCriterion("F_crawler_enabled not between", value1, value2, "fCrawlerEnabled");
            return (Criteria) this;
        }

        public Criteria andFUseProxyIsNull() {
            addCriterion("F_use_proxy is null");
            return (Criteria) this;
        }

        public Criteria andFUseProxyIsNotNull() {
            addCriterion("F_use_proxy is not null");
            return (Criteria) this;
        }

        public Criteria andFUseProxyEqualTo(Byte value) {
            addCriterion("F_use_proxy =", value, "fUseProxy");
            return (Criteria) this;
        }

        public Criteria andFUseProxyNotEqualTo(Byte value) {
            addCriterion("F_use_proxy <>", value, "fUseProxy");
            return (Criteria) this;
        }

        public Criteria andFUseProxyGreaterThan(Byte value) {
            addCriterion("F_use_proxy >", value, "fUseProxy");
            return (Criteria) this;
        }

        public Criteria andFUseProxyGreaterThanOrEqualTo(Byte value) {
            addCriterion("F_use_proxy >=", value, "fUseProxy");
            return (Criteria) this;
        }

        public Criteria andFUseProxyLessThan(Byte value) {
            addCriterion("F_use_proxy <", value, "fUseProxy");
            return (Criteria) this;
        }

        public Criteria andFUseProxyLessThanOrEqualTo(Byte value) {
            addCriterion("F_use_proxy <=", value, "fUseProxy");
            return (Criteria) this;
        }

        public Criteria andFUseProxyIn(List<Byte> values) {
            addCriterion("F_use_proxy in", values, "fUseProxy");
            return (Criteria) this;
        }

        public Criteria andFUseProxyNotIn(List<Byte> values) {
            addCriterion("F_use_proxy not in", values, "fUseProxy");
            return (Criteria) this;
        }

        public Criteria andFUseProxyBetween(Byte value1, Byte value2) {
            addCriterion("F_use_proxy between", value1, value2, "fUseProxy");
            return (Criteria) this;
        }

        public Criteria andFUseProxyNotBetween(Byte value1, Byte value2) {
            addCriterion("F_use_proxy not between", value1, value2, "fUseProxy");
            return (Criteria) this;
        }

        public Criteria andFCrawlDepthIsNull() {
            addCriterion("F_crawl_depth is null");
            return (Criteria) this;
        }

        public Criteria andFCrawlDepthIsNotNull() {
            addCriterion("F_crawl_depth is not null");
            return (Criteria) this;
        }

        public Criteria andFCrawlDepthEqualTo(Integer value) {
            addCriterion("F_crawl_depth =", value, "fCrawlDepth");
            return (Criteria) this;
        }

        public Criteria andFCrawlDepthNotEqualTo(Integer value) {
            addCriterion("F_crawl_depth <>", value, "fCrawlDepth");
            return (Criteria) this;
        }

        public Criteria andFCrawlDepthGreaterThan(Integer value) {
            addCriterion("F_crawl_depth >", value, "fCrawlDepth");
            return (Criteria) this;
        }

        public Criteria andFCrawlDepthGreaterThanOrEqualTo(Integer value) {
            addCriterion("F_crawl_depth >=", value, "fCrawlDepth");
            return (Criteria) this;
        }

        public Criteria andFCrawlDepthLessThan(Integer value) {
            addCriterion("F_crawl_depth <", value, "fCrawlDepth");
            return (Criteria) this;
        }

        public Criteria andFCrawlDepthLessThanOrEqualTo(Integer value) {
            addCriterion("F_crawl_depth <=", value, "fCrawlDepth");
            return (Criteria) this;
        }

        public Criteria andFCrawlDepthIn(List<Integer> values) {
            addCriterion("F_crawl_depth in", values, "fCrawlDepth");
            return (Criteria) this;
        }

        public Criteria andFCrawlDepthNotIn(List<Integer> values) {
            addCriterion("F_crawl_depth not in", values, "fCrawlDepth");
            return (Criteria) this;
        }

        public Criteria andFCrawlDepthBetween(Integer value1, Integer value2) {
            addCriterion("F_crawl_depth between", value1, value2, "fCrawlDepth");
            return (Criteria) this;
        }

        public Criteria andFCrawlDepthNotBetween(Integer value1, Integer value2) {
            addCriterion("F_crawl_depth not between", value1, value2, "fCrawlDepth");
            return (Criteria) this;
        }

        public Criteria andFLanIsNull() {
            addCriterion("F_lan is null");
            return (Criteria) this;
        }

        public Criteria andFLanIsNotNull() {
            addCriterion("F_lan is not null");
            return (Criteria) this;
        }

        public Criteria andFLanEqualTo(String value) {
            addCriterion("F_lan =", value, "fLan");
            return (Criteria) this;
        }

        public Criteria andFLanNotEqualTo(String value) {
            addCriterion("F_lan <>", value, "fLan");
            return (Criteria) this;
        }

        public Criteria andFLanGreaterThan(String value) {
            addCriterion("F_lan >", value, "fLan");
            return (Criteria) this;
        }

        public Criteria andFLanGreaterThanOrEqualTo(String value) {
            addCriterion("F_lan >=", value, "fLan");
            return (Criteria) this;
        }

        public Criteria andFLanLessThan(String value) {
            addCriterion("F_lan <", value, "fLan");
            return (Criteria) this;
        }

        public Criteria andFLanLessThanOrEqualTo(String value) {
            addCriterion("F_lan <=", value, "fLan");
            return (Criteria) this;
        }

        public Criteria andFLanLike(String value) {
            addCriterion("F_lan like", value, "fLan");
            return (Criteria) this;
        }

        public Criteria andFLanNotLike(String value) {
            addCriterion("F_lan not like", value, "fLan");
            return (Criteria) this;
        }

        public Criteria andFLanIn(List<String> values) {
            addCriterion("F_lan in", values, "fLan");
            return (Criteria) this;
        }

        public Criteria andFLanNotIn(List<String> values) {
            addCriterion("F_lan not in", values, "fLan");
            return (Criteria) this;
        }

        public Criteria andFLanBetween(String value1, String value2) {
            addCriterion("F_lan between", value1, value2, "fLan");
            return (Criteria) this;
        }

        public Criteria andFLanNotBetween(String value1, String value2) {
            addCriterion("F_lan not between", value1, value2, "fLan");
            return (Criteria) this;
        }

        public Criteria andFCountryIsNull() {
            addCriterion("F_country is null");
            return (Criteria) this;
        }

        public Criteria andFCountryIsNotNull() {
            addCriterion("F_country is not null");
            return (Criteria) this;
        }

        public Criteria andFCountryEqualTo(String value) {
            addCriterion("F_country =", value, "fCountry");
            return (Criteria) this;
        }

        public Criteria andFCountryNotEqualTo(String value) {
            addCriterion("F_country <>", value, "fCountry");
            return (Criteria) this;
        }

        public Criteria andFCountryGreaterThan(String value) {
            addCriterion("F_country >", value, "fCountry");
            return (Criteria) this;
        }

        public Criteria andFCountryGreaterThanOrEqualTo(String value) {
            addCriterion("F_country >=", value, "fCountry");
            return (Criteria) this;
        }

        public Criteria andFCountryLessThan(String value) {
            addCriterion("F_country <", value, "fCountry");
            return (Criteria) this;
        }

        public Criteria andFCountryLessThanOrEqualTo(String value) {
            addCriterion("F_country <=", value, "fCountry");
            return (Criteria) this;
        }

        public Criteria andFCountryLike(String value) {
            addCriterion("F_country like", value, "fCountry");
            return (Criteria) this;
        }

        public Criteria andFCountryNotLike(String value) {
            addCriterion("F_country not like", value, "fCountry");
            return (Criteria) this;
        }

        public Criteria andFCountryIn(List<String> values) {
            addCriterion("F_country in", values, "fCountry");
            return (Criteria) this;
        }

        public Criteria andFCountryNotIn(List<String> values) {
            addCriterion("F_country not in", values, "fCountry");
            return (Criteria) this;
        }

        public Criteria andFCountryBetween(String value1, String value2) {
            addCriterion("F_country between", value1, value2, "fCountry");
            return (Criteria) this;
        }

        public Criteria andFCountryNotBetween(String value1, String value2) {
            addCriterion("F_country not between", value1, value2, "fCountry");
            return (Criteria) this;
        }

        public Criteria andFSourceCategoryIsNull() {
            addCriterion("F_source_category is null");
            return (Criteria) this;
        }

        public Criteria andFSourceCategoryIsNotNull() {
            addCriterion("F_source_category is not null");
            return (Criteria) this;
        }

        public Criteria andFSourceCategoryEqualTo(String value) {
            addCriterion("F_source_category =", value, "fSourceCategory");
            return (Criteria) this;
        }

        public Criteria andFSourceCategoryNotEqualTo(String value) {
            addCriterion("F_source_category <>", value, "fSourceCategory");
            return (Criteria) this;
        }

        public Criteria andFSourceCategoryGreaterThan(String value) {
            addCriterion("F_source_category >", value, "fSourceCategory");
            return (Criteria) this;
        }

        public Criteria andFSourceCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("F_source_category >=", value, "fSourceCategory");
            return (Criteria) this;
        }

        public Criteria andFSourceCategoryLessThan(String value) {
            addCriterion("F_source_category <", value, "fSourceCategory");
            return (Criteria) this;
        }

        public Criteria andFSourceCategoryLessThanOrEqualTo(String value) {
            addCriterion("F_source_category <=", value, "fSourceCategory");
            return (Criteria) this;
        }

        public Criteria andFSourceCategoryLike(String value) {
            addCriterion("F_source_category like", value, "fSourceCategory");
            return (Criteria) this;
        }

        public Criteria andFSourceCategoryNotLike(String value) {
            addCriterion("F_source_category not like", value, "fSourceCategory");
            return (Criteria) this;
        }

        public Criteria andFSourceCategoryIn(List<String> values) {
            addCriterion("F_source_category in", values, "fSourceCategory");
            return (Criteria) this;
        }

        public Criteria andFSourceCategoryNotIn(List<String> values) {
            addCriterion("F_source_category not in", values, "fSourceCategory");
            return (Criteria) this;
        }

        public Criteria andFSourceCategoryBetween(String value1, String value2) {
            addCriterion("F_source_category between", value1, value2, "fSourceCategory");
            return (Criteria) this;
        }

        public Criteria andFSourceCategoryNotBetween(String value1, String value2) {
            addCriterion("F_source_category not between", value1, value2, "fSourceCategory");
            return (Criteria) this;
        }

        public Criteria andFPlatformCategoryIsNull() {
            addCriterion("F_platform_category is null");
            return (Criteria) this;
        }

        public Criteria andFPlatformCategoryIsNotNull() {
            addCriterion("F_platform_category is not null");
            return (Criteria) this;
        }

        public Criteria andFPlatformCategoryEqualTo(String value) {
            addCriterion("F_platform_category =", value, "fPlatformCategory");
            return (Criteria) this;
        }

        public Criteria andFPlatformCategoryNotEqualTo(String value) {
            addCriterion("F_platform_category <>", value, "fPlatformCategory");
            return (Criteria) this;
        }

        public Criteria andFPlatformCategoryGreaterThan(String value) {
            addCriterion("F_platform_category >", value, "fPlatformCategory");
            return (Criteria) this;
        }

        public Criteria andFPlatformCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("F_platform_category >=", value, "fPlatformCategory");
            return (Criteria) this;
        }

        public Criteria andFPlatformCategoryLessThan(String value) {
            addCriterion("F_platform_category <", value, "fPlatformCategory");
            return (Criteria) this;
        }

        public Criteria andFPlatformCategoryLessThanOrEqualTo(String value) {
            addCriterion("F_platform_category <=", value, "fPlatformCategory");
            return (Criteria) this;
        }

        public Criteria andFPlatformCategoryLike(String value) {
            addCriterion("F_platform_category like", value, "fPlatformCategory");
            return (Criteria) this;
        }

        public Criteria andFPlatformCategoryNotLike(String value) {
            addCriterion("F_platform_category not like", value, "fPlatformCategory");
            return (Criteria) this;
        }

        public Criteria andFPlatformCategoryIn(List<String> values) {
            addCriterion("F_platform_category in", values, "fPlatformCategory");
            return (Criteria) this;
        }

        public Criteria andFPlatformCategoryNotIn(List<String> values) {
            addCriterion("F_platform_category not in", values, "fPlatformCategory");
            return (Criteria) this;
        }

        public Criteria andFPlatformCategoryBetween(String value1, String value2) {
            addCriterion("F_platform_category between", value1, value2, "fPlatformCategory");
            return (Criteria) this;
        }

        public Criteria andFPlatformCategoryNotBetween(String value1, String value2) {
            addCriterion("F_platform_category not between", value1, value2, "fPlatformCategory");
            return (Criteria) this;
        }

        public Criteria andFMediaIsNull() {
            addCriterion("F_media is null");
            return (Criteria) this;
        }

        public Criteria andFMediaIsNotNull() {
            addCriterion("F_media is not null");
            return (Criteria) this;
        }

        public Criteria andFMediaEqualTo(String value) {
            addCriterion("F_media =", value, "fMedia");
            return (Criteria) this;
        }

        public Criteria andFMediaNotEqualTo(String value) {
            addCriterion("F_media <>", value, "fMedia");
            return (Criteria) this;
        }

        public Criteria andFMediaGreaterThan(String value) {
            addCriterion("F_media >", value, "fMedia");
            return (Criteria) this;
        }

        public Criteria andFMediaGreaterThanOrEqualTo(String value) {
            addCriterion("F_media >=", value, "fMedia");
            return (Criteria) this;
        }

        public Criteria andFMediaLessThan(String value) {
            addCriterion("F_media <", value, "fMedia");
            return (Criteria) this;
        }

        public Criteria andFMediaLessThanOrEqualTo(String value) {
            addCriterion("F_media <=", value, "fMedia");
            return (Criteria) this;
        }

        public Criteria andFMediaLike(String value) {
            addCriterion("F_media like", value, "fMedia");
            return (Criteria) this;
        }

        public Criteria andFMediaNotLike(String value) {
            addCriterion("F_media not like", value, "fMedia");
            return (Criteria) this;
        }

        public Criteria andFMediaIn(List<String> values) {
            addCriterion("F_media in", values, "fMedia");
            return (Criteria) this;
        }

        public Criteria andFMediaNotIn(List<String> values) {
            addCriterion("F_media not in", values, "fMedia");
            return (Criteria) this;
        }

        public Criteria andFMediaBetween(String value1, String value2) {
            addCriterion("F_media between", value1, value2, "fMedia");
            return (Criteria) this;
        }

        public Criteria andFMediaNotBetween(String value1, String value2) {
            addCriterion("F_media not between", value1, value2, "fMedia");
            return (Criteria) this;
        }

        public Criteria andFParserIsNull() {
            addCriterion("F_parser is null");
            return (Criteria) this;
        }

        public Criteria andFParserIsNotNull() {
            addCriterion("F_parser is not null");
            return (Criteria) this;
        }

        public Criteria andFParserEqualTo(String value) {
            addCriterion("F_parser =", value, "fParser");
            return (Criteria) this;
        }

        public Criteria andFParserNotEqualTo(String value) {
            addCriterion("F_parser <>", value, "fParser");
            return (Criteria) this;
        }

        public Criteria andFParserGreaterThan(String value) {
            addCriterion("F_parser >", value, "fParser");
            return (Criteria) this;
        }

        public Criteria andFParserGreaterThanOrEqualTo(String value) {
            addCriterion("F_parser >=", value, "fParser");
            return (Criteria) this;
        }

        public Criteria andFParserLessThan(String value) {
            addCriterion("F_parser <", value, "fParser");
            return (Criteria) this;
        }

        public Criteria andFParserLessThanOrEqualTo(String value) {
            addCriterion("F_parser <=", value, "fParser");
            return (Criteria) this;
        }

        public Criteria andFParserLike(String value) {
            addCriterion("F_parser like", value, "fParser");
            return (Criteria) this;
        }

        public Criteria andFParserNotLike(String value) {
            addCriterion("F_parser not like", value, "fParser");
            return (Criteria) this;
        }

        public Criteria andFParserIn(List<String> values) {
            addCriterion("F_parser in", values, "fParser");
            return (Criteria) this;
        }

        public Criteria andFParserNotIn(List<String> values) {
            addCriterion("F_parser not in", values, "fParser");
            return (Criteria) this;
        }

        public Criteria andFParserBetween(String value1, String value2) {
            addCriterion("F_parser between", value1, value2, "fParser");
            return (Criteria) this;
        }

        public Criteria andFParserNotBetween(String value1, String value2) {
            addCriterion("F_parser not between", value1, value2, "fParser");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeIsNull() {
            addCriterion("F_create_time is null");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeIsNotNull() {
            addCriterion("F_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeEqualTo(Date value) {
            addCriterion("F_create_time =", value, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeNotEqualTo(Date value) {
            addCriterion("F_create_time <>", value, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeGreaterThan(Date value) {
            addCriterion("F_create_time >", value, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("F_create_time >=", value, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeLessThan(Date value) {
            addCriterion("F_create_time <", value, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("F_create_time <=", value, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeIn(List<Date> values) {
            addCriterion("F_create_time in", values, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeNotIn(List<Date> values) {
            addCriterion("F_create_time not in", values, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeBetween(Date value1, Date value2) {
            addCriterion("F_create_time between", value1, value2, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("F_create_time not between", value1, value2, "fCreateTime");
            return (Criteria) this;
        }

        public Criteria andFModifyTimeIsNull() {
            addCriterion("F_modify_time is null");
            return (Criteria) this;
        }

        public Criteria andFModifyTimeIsNotNull() {
            addCriterion("F_modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andFModifyTimeEqualTo(Date value) {
            addCriterion("F_modify_time =", value, "fModifyTime");
            return (Criteria) this;
        }

        public Criteria andFModifyTimeNotEqualTo(Date value) {
            addCriterion("F_modify_time <>", value, "fModifyTime");
            return (Criteria) this;
        }

        public Criteria andFModifyTimeGreaterThan(Date value) {
            addCriterion("F_modify_time >", value, "fModifyTime");
            return (Criteria) this;
        }

        public Criteria andFModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("F_modify_time >=", value, "fModifyTime");
            return (Criteria) this;
        }

        public Criteria andFModifyTimeLessThan(Date value) {
            addCriterion("F_modify_time <", value, "fModifyTime");
            return (Criteria) this;
        }

        public Criteria andFModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("F_modify_time <=", value, "fModifyTime");
            return (Criteria) this;
        }

        public Criteria andFModifyTimeIn(List<Date> values) {
            addCriterion("F_modify_time in", values, "fModifyTime");
            return (Criteria) this;
        }

        public Criteria andFModifyTimeNotIn(List<Date> values) {
            addCriterion("F_modify_time not in", values, "fModifyTime");
            return (Criteria) this;
        }

        public Criteria andFModifyTimeBetween(Date value1, Date value2) {
            addCriterion("F_modify_time between", value1, value2, "fModifyTime");
            return (Criteria) this;
        }

        public Criteria andFModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("F_modify_time not between", value1, value2, "fModifyTime");
            return (Criteria) this;
        }

        public Criteria andFLastCrawlTimeIsNull() {
            addCriterion("F_last_crawl_time is null");
            return (Criteria) this;
        }

        public Criteria andFLastCrawlTimeIsNotNull() {
            addCriterion("F_last_crawl_time is not null");
            return (Criteria) this;
        }

        public Criteria andFLastCrawlTimeEqualTo(Date value) {
            addCriterion("F_last_crawl_time =", value, "fLastCrawlTime");
            return (Criteria) this;
        }

        public Criteria andFLastCrawlTimeNotEqualTo(Date value) {
            addCriterion("F_last_crawl_time <>", value, "fLastCrawlTime");
            return (Criteria) this;
        }

        public Criteria andFLastCrawlTimeGreaterThan(Date value) {
            addCriterion("F_last_crawl_time >", value, "fLastCrawlTime");
            return (Criteria) this;
        }

        public Criteria andFLastCrawlTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("F_last_crawl_time >=", value, "fLastCrawlTime");
            return (Criteria) this;
        }

        public Criteria andFLastCrawlTimeLessThan(Date value) {
            addCriterion("F_last_crawl_time <", value, "fLastCrawlTime");
            return (Criteria) this;
        }

        public Criteria andFLastCrawlTimeLessThanOrEqualTo(Date value) {
            addCriterion("F_last_crawl_time <=", value, "fLastCrawlTime");
            return (Criteria) this;
        }

        public Criteria andFLastCrawlTimeIn(List<Date> values) {
            addCriterion("F_last_crawl_time in", values, "fLastCrawlTime");
            return (Criteria) this;
        }

        public Criteria andFLastCrawlTimeNotIn(List<Date> values) {
            addCriterion("F_last_crawl_time not in", values, "fLastCrawlTime");
            return (Criteria) this;
        }

        public Criteria andFLastCrawlTimeBetween(Date value1, Date value2) {
            addCriterion("F_last_crawl_time between", value1, value2, "fLastCrawlTime");
            return (Criteria) this;
        }

        public Criteria andFLastCrawlTimeNotBetween(Date value1, Date value2) {
            addCriterion("F_last_crawl_time not between", value1, value2, "fLastCrawlTime");
            return (Criteria) this;
        }

        public Criteria andFNextCrawlTimeIsNull() {
            addCriterion("F_next_crawl_time is null");
            return (Criteria) this;
        }

        public Criteria andFNextCrawlTimeIsNotNull() {
            addCriterion("F_next_crawl_time is not null");
            return (Criteria) this;
        }

        public Criteria andFNextCrawlTimeEqualTo(Date value) {
            addCriterion("F_next_crawl_time =", value, "fNextCrawlTime");
            return (Criteria) this;
        }

        public Criteria andFNextCrawlTimeNotEqualTo(Date value) {
            addCriterion("F_next_crawl_time <>", value, "fNextCrawlTime");
            return (Criteria) this;
        }

        public Criteria andFNextCrawlTimeGreaterThan(Date value) {
            addCriterion("F_next_crawl_time >", value, "fNextCrawlTime");
            return (Criteria) this;
        }

        public Criteria andFNextCrawlTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("F_next_crawl_time >=", value, "fNextCrawlTime");
            return (Criteria) this;
        }

        public Criteria andFNextCrawlTimeLessThan(Date value) {
            addCriterion("F_next_crawl_time <", value, "fNextCrawlTime");
            return (Criteria) this;
        }

        public Criteria andFNextCrawlTimeLessThanOrEqualTo(Date value) {
            addCriterion("F_next_crawl_time <=", value, "fNextCrawlTime");
            return (Criteria) this;
        }

        public Criteria andFNextCrawlTimeIn(List<Date> values) {
            addCriterion("F_next_crawl_time in", values, "fNextCrawlTime");
            return (Criteria) this;
        }

        public Criteria andFNextCrawlTimeNotIn(List<Date> values) {
            addCriterion("F_next_crawl_time not in", values, "fNextCrawlTime");
            return (Criteria) this;
        }

        public Criteria andFNextCrawlTimeBetween(Date value1, Date value2) {
            addCriterion("F_next_crawl_time between", value1, value2, "fNextCrawlTime");
            return (Criteria) this;
        }

        public Criteria andFNextCrawlTimeNotBetween(Date value1, Date value2) {
            addCriterion("F_next_crawl_time not between", value1, value2, "fNextCrawlTime");
            return (Criteria) this;
        }

        public Criteria andFCrawlIntervalIsNull() {
            addCriterion("F_crawl_interval is null");
            return (Criteria) this;
        }

        public Criteria andFCrawlIntervalIsNotNull() {
            addCriterion("F_crawl_interval is not null");
            return (Criteria) this;
        }

        public Criteria andFCrawlIntervalEqualTo(Integer value) {
            addCriterion("F_crawl_interval =", value, "fCrawlInterval");
            return (Criteria) this;
        }

        public Criteria andFCrawlIntervalNotEqualTo(Integer value) {
            addCriterion("F_crawl_interval <>", value, "fCrawlInterval");
            return (Criteria) this;
        }

        public Criteria andFCrawlIntervalGreaterThan(Integer value) {
            addCriterion("F_crawl_interval >", value, "fCrawlInterval");
            return (Criteria) this;
        }

        public Criteria andFCrawlIntervalGreaterThanOrEqualTo(Integer value) {
            addCriterion("F_crawl_interval >=", value, "fCrawlInterval");
            return (Criteria) this;
        }

        public Criteria andFCrawlIntervalLessThan(Integer value) {
            addCriterion("F_crawl_interval <", value, "fCrawlInterval");
            return (Criteria) this;
        }

        public Criteria andFCrawlIntervalLessThanOrEqualTo(Integer value) {
            addCriterion("F_crawl_interval <=", value, "fCrawlInterval");
            return (Criteria) this;
        }

        public Criteria andFCrawlIntervalIn(List<Integer> values) {
            addCriterion("F_crawl_interval in", values, "fCrawlInterval");
            return (Criteria) this;
        }

        public Criteria andFCrawlIntervalNotIn(List<Integer> values) {
            addCriterion("F_crawl_interval not in", values, "fCrawlInterval");
            return (Criteria) this;
        }

        public Criteria andFCrawlIntervalBetween(Integer value1, Integer value2) {
            addCriterion("F_crawl_interval between", value1, value2, "fCrawlInterval");
            return (Criteria) this;
        }

        public Criteria andFCrawlIntervalNotBetween(Integer value1, Integer value2) {
            addCriterion("F_crawl_interval not between", value1, value2, "fCrawlInterval");
            return (Criteria) this;
        }

        public Criteria andFCrawlThreadsIsNull() {
            addCriterion("F_crawl_threads is null");
            return (Criteria) this;
        }

        public Criteria andFCrawlThreadsIsNotNull() {
            addCriterion("F_crawl_threads is not null");
            return (Criteria) this;
        }

        public Criteria andFCrawlThreadsEqualTo(Integer value) {
            addCriterion("F_crawl_threads =", value, "fCrawlThreads");
            return (Criteria) this;
        }

        public Criteria andFCrawlThreadsNotEqualTo(Integer value) {
            addCriterion("F_crawl_threads <>", value, "fCrawlThreads");
            return (Criteria) this;
        }

        public Criteria andFCrawlThreadsGreaterThan(Integer value) {
            addCriterion("F_crawl_threads >", value, "fCrawlThreads");
            return (Criteria) this;
        }

        public Criteria andFCrawlThreadsGreaterThanOrEqualTo(Integer value) {
            addCriterion("F_crawl_threads >=", value, "fCrawlThreads");
            return (Criteria) this;
        }

        public Criteria andFCrawlThreadsLessThan(Integer value) {
            addCriterion("F_crawl_threads <", value, "fCrawlThreads");
            return (Criteria) this;
        }

        public Criteria andFCrawlThreadsLessThanOrEqualTo(Integer value) {
            addCriterion("F_crawl_threads <=", value, "fCrawlThreads");
            return (Criteria) this;
        }

        public Criteria andFCrawlThreadsIn(List<Integer> values) {
            addCriterion("F_crawl_threads in", values, "fCrawlThreads");
            return (Criteria) this;
        }

        public Criteria andFCrawlThreadsNotIn(List<Integer> values) {
            addCriterion("F_crawl_threads not in", values, "fCrawlThreads");
            return (Criteria) this;
        }

        public Criteria andFCrawlThreadsBetween(Integer value1, Integer value2) {
            addCriterion("F_crawl_threads between", value1, value2, "fCrawlThreads");
            return (Criteria) this;
        }

        public Criteria andFCrawlThreadsNotBetween(Integer value1, Integer value2) {
            addCriterion("F_crawl_threads not between", value1, value2, "fCrawlThreads");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}