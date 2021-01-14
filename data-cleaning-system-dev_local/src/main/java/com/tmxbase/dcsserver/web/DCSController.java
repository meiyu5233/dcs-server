package com.tmxbase.dcsserver.web;

import com.tmxbase.dcsserver.base.model.SiteSource;
import com.tmxbase.dcsserver.service.DCSProcess;
import com.tmxbase.utils.ControllerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dcs")
public class DCSController {

    @Autowired
    private DCSProcess dcsProcess;

    /**
     * @param siteSource
     * @return
     * @description 创建源站信息
     */
    @PostMapping("/siteSource")
    public Map<String, Object> createSiteSource(@RequestBody SiteSource siteSource) {
        dcsProcess.insertSiteSource(siteSource);
        return ControllerUtil.getResultMap();
    }

    /**
     * @param siteSource
     * @param id
     * @return
     * @description 更新源站信息
     */
    @PostMapping("/siteSource/{id}/_update")
    public Map<String, Object> updateSiteSource(@RequestBody SiteSource siteSource, @PathVariable String id) {
        dcsProcess.updateSiteSource(siteSource, id);
        return ControllerUtil.getResultMap();
    }

    /**
     * @param id
     * @return
     * @description 删除源站信息
     */
    @PostMapping("/siteSource/{id}/_delete")
    public Map<String, Object> deleteSiteSource(@PathVariable String id) {
        dcsProcess.deleteSiteSource(id);
        return ControllerUtil.getResultMap();
    }

    /**
     * @param id
     * @return
     * @description 获取源站信息
     */
    @GetMapping("/siteSource")
    public Map<String, Object> getSiteSource(@RequestParam(required = false) String id) {
        Map<String, Object> resultMap = ControllerUtil.getResultMap();
        List<SiteSource> siteSourceList = dcsProcess.getSiteSource(id);
        resultMap.put("siteSource", siteSourceList);
        return resultMap;
    }

    /**
     * @return
     * @description 手动开始爬虫任务
     */
    @PostMapping("/siteSource/_crawl")
    public Map<String, Object> startCrawler() throws Exception {
        dcsProcess.startCrawlerTask();
        return ControllerUtil.getResultMap();
    }


    @PostMapping("/siteSource/_stop")
    public Map<String, Object> stopSiteSource(@RequestParam String id) {
        dcsProcess.stopSiteSource(id);
        return ControllerUtil.getResultMap();
    }
}
