CREATE TABLE `t_crawler_source_site` (
  `F_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `F_enabled` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '物理有效标志',
  `F_source_site_id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '源站ID',
  `F_source_site_name` varchar(128) COLLATE utf8_bin NOT NULL COMMENT '源站名称',
  `F_source_site_uri` varchar(256) COLLATE utf8_bin NOT NULL COMMENT '源站uri',
  `F_crawler_status` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '搜藏id',
  `F_crawler_enabled` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '爬虫启用状态',
  `F_use_proxy` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '爬虫是否使用代理',
  `F_crawl_depth` int(11) NOT NULL DEFAULT '3' COMMENT '爬虫爬取深度',
  `F_lan` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '网站语言',
  `F_country` varchar(256) COLLATE utf8_bin NOT NULL COMMENT '地区',
  `F_source_category` varchar(256) COLLATE utf8_bin NOT NULL COMMENT '来源类别',
  `F_platform_category` varchar(256) COLLATE utf8_bin NOT NULL COMMENT '平台类别',
  `F_media` varchar(256) COLLATE utf8_bin NOT NULL COMMENT '媒体类型',
  `F_parser` varchar(256) COLLATE utf8_bin NOT NULL COMMENT '指定解析器',
  `F_create_time` datetime NOT NULL DEFAULT '2014-07-01 00:00:00' COMMENT '创建时间',
  `F_modify_time` datetime NOT NULL DEFAULT '2014-07-01 00:00:00' COMMENT '修改时间',
  `F_last_crawl_time` datetime DEFAULT NULL COMMENT '上次抓取时间',
  `F_next_crawl_time` datetime DEFAULT NULL COMMENT '下次预计抓取时间',
  `F_crawl_interval` int(11) NOT NULL DEFAULT '7' COMMENT '爬取间隔，单位天',
  `F_crawl_threads` int(11) NOT NULL DEFAULT '5' COMMENT '开启的线程数',
  PRIMARY KEY (`F_id`),
  UNIQUE KEY `I_source_site_id` (`F_source_site_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;