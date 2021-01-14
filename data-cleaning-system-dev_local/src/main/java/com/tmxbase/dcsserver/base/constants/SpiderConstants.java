package com.tmxbase.dcsserver.base.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @Designation:
 * @Author: Ylz
 * @Date: 2019/10/12
 * @Version: 1.0
 */
public class SpiderConstants {

    private SpiderConstants() {
    }

    private static Map<String, String> countryMap = new HashMap<>();
    private static Map<String, String> lanMap = new HashMap<>();
    private static Map<String, String> mediaMap = new HashMap<>();
    private static Map<String, String> sourceCodeMap = new HashMap<>();
    private static Map<String, String> platformMap = new HashMap<>();
    private static Map<String, String> sourceMap = new HashMap<>();
    private static Map<String, String> provinceMap = new HashMap<>();
    private static Map<String, String> cityMap = new HashMap<>();

    /**
     * 语种，短
     */
    public static final String LAN_ZH = "zh"; //中文标识
    public static final String LAN_EN = "en"; //英文 标识
    public static final String LAN_JA = "ja"; //日文标识
    public static final String LAN_KO = "ko"; //韩文标识
    public static final String LAN_RU = "ru"; //俄文标识
    public static final String LAN_DE = "de"; //德文标识
    public static final String LAN_ES = "es"; //西班牙文标识
    public static final String LAN_FR = "fr"; //法文标识
    public static final String LAN_PT = "pt"; //葡萄牙文标识
    public static final String LAN_AR = "ar"; //阿拉伯文标识
    public static final String LAN_TH = "th";//泰语
    public static final String LAN_VI = "vi";//越南语
    public static final String LAN_MY = "my";//缅甸语
    public static final String LAN_ID = "id";//印尼语
    public static final String LAN_KM = "km";//柬埔寨语
    public static final String LAN_LO = "lo";//老挝语
    public static final String LAN_MS = "ms";//马来语
    public static final String LAN_FIL = "fil";//菲律宾语
    public static final String LAN_EL = "el";//希腊语

    /**
     * 欧洲小语种及其他
     */
    public static final String LAN_IT = "it";//意大利语
    public static final String LAN_TR = "tr";//土耳其语
    public static final String LAN_UK = "uk";//乌克兰语
    public static final String LAN_SV = "sv";//瑞典语
    public static final String LAN_CS = "cs";//捷克语
    public static final String LAN_SK = "sk";//斯洛伐克语
    public static final String LAN_SL = "sl";//斯洛文尼亚语
    public static final String LAN_PL = "pl";//波兰语
    public static final String LAN_DA = "da";//丹麦语
    public static final String LAN_NL = "nl";//荷兰语
    public static final String LAN_FI = "fi";//芬兰语
    public static final String LAN_HU = "hu";//匈牙利语
    public static final String LAN_HI = "hi";//印地语
    public static final String LAN_HE = "he";//希伯来语
    public static final String LAN_BN = "bn";//孟加拉语
    public static final String LAN_HY = "hy";//亚美尼亚语
    public static final String LAN_BO = "bo";//藏语
    public static final String LAN_UG = "ug";//维语
    public static final String LAN_II = "ii";//彝语
    public static final String LAN_LA = "la";//拉丁语
    public static final String LAN_RO = "ro";//罗马尼亚语
    public static final String LAN_BG = "bg";//保加利亚语
    public static final String LAN_HR = "hr";//克罗地亚语
    public static final String LAN_SQ = "sq";//阿尔巴尼亚语
    public static final String LAN_MK = "mk";//马其顿语
    public static final String LAN_ET = "et";//爱沙尼亚语
    public static final String LAN_LT = "lt";//立陶宛语
    public static final String LAN_MN = "mn";//蒙古语
    public static final String LAN_KK = "kk";//哈萨克语
    public static final String LAN_ZA = "za";//状语

    //域名
    public static final String PEOPLE_WEBSITE_DOMAIN = "www.people.com.cn";
    public static final String CHINADAILY_DOMAIN = "cn.chinadaily.com.cn";
    public static final String GXNEWS_DOMAIN = "www.gxnews.com.cn";
    public static final String HUANQIU_DOMAIN = "www.huanqiu.com";
    public static final String XINHUANET_DOMAIN = "www.xinhuanet.com";
    public static final String BJNEWS_DOMAIN = "www.bjnews.com.cn";
    public static final String CHINANEWS_DOMAIN = "www.chinanews.com";
    public static final String SINA_DOMAIN = "www.sina.com.cn";
    public static final String GXRB_DOMAIN = "gxrb.gxrb.com.cn";
    public static final String NGZB_DOMAIN = "www.ngzb.com.cn";
    public static final String SINCHEW_DOMAIN = "www.sinchew.com.my";
    public static final String MALAYSINAKINI_DOMAIN = "www.malaysiakini.com";
    public static final String JAKARTAGLOBE_DOMAIN = "jakartaglobe.id";
    public static final String NHANDAN_DOMAIN = "www.nhandan.org.vn";
    public static final String PASAXON_DOMAIN = "www.pasaxon.org.la";
    public static final String DAILYDEMOCRACYTODAY_DOMAIN = "www.dailydemocracytoday.com";
    public static final String MANILATIMES_DOMAIN = "www.manilatimes.net";
    public static final String LEAGAL_AND_ECONOMY_MAGAZINE_DOMAIN = "www.fzyjjzz.com.cn";
    public static final String SOUTH_SCIENCE_PAGE_DOMAIN = "www.nfkjw.com";
    public static final String KOHSAMTEPHEAP_DAILY_DOMAIN = "kohsantepheapdaily.com.kh";
    public static final String SHANGBAO_DOMAIN = "www.shangbao.com.ph";
    public static final String BRUNEITOURISM_DOMAIN = "bruneitourism.com";
    public static final String KOMPAS_DOMAIN = "www.kompas.com";
    public static final String BALITA_DOMAIN = "balita.net.ph";
    public static final String THAIRATH_DOMAIN = "www.thairath.co.th";
    public static final String BERITAHARIAN_DOMAIN = "www.beritaharian.sg";
    public static final String MOF_GOV_DOMAIN = "www.mof.gov.tl";
    public static final String GXZF_GOV_DOMAIN = "www.gxzf.gov.cn";
    public static final String GXUFE_EDU_DOMAIN = "www.gxufe.edu.cn";
    public static final String GXU_EDU_DOMAIN = "www.gxu.edu.cn";
    public static final String CTRIP_DOMAIN = "www.ctrip.com";
    public static final String NANNING_GOV_DOMAIN = "www.nanning.gov.cn";
    public static final String LIUZHOU_GOV_DOMAIN = "www.liuzhou.gov.cn";
    public static final String GUILIN_GOV_DOMAIN = "www.guilin.gov.cn";
    public static final String GXSTNU_EDU_DOMAIN = "www.gxstnu.edu.cn";
    public static final String GXTCMU_EDU_DOMAIN = "www.gxtcmu.edu.cn";
    public static final String GXNU_EDU_DOMAIN = "www.gxnu.edu.cn";
    public static final String GUOJIRIBAO_DOMAIN = "www.guojiribao.com";
    public static final String DAILYEXPRESS_DOMAIN = "www.dailyexpress.com.my";
    public static final String TUOITRE_DOMAIN = "tuoitre.vn";
    public static final String KPL_GOV_DOMAIN = "kpl.gov.la";
    public static final String DAILYNEWS_DOMAIN = "www.dailynews.co.th";

    public static final String GLTU_EDU_DOMAIN = "www.gltu.edu.cn";
    public static final String GLIET_EDU_DOMAIN = "www.gliet.edu.cn";
    public static final String GXUWZ_EDU_DOMAIN = "www.gxuwz.edu.cn";

    public static final String WUZHOU_GOV_DOMAIN = "www.wuzhou.gov.cn";
    public static final String GXHZ_GOV_DOMAIN = "www.gxhz.gov.cn";
    public static final String YULIN_GOV_DOMAIN = "www.yulin.gov.cn";

    public static final String THEBORNEOPOST_DOMAIN = "www.theborneopost.com";
    public static final String ENANYANG_DOMAIN = "www.enanyang.my";
    public static final String SHANGBAOINDONESIA_DOMAIN = "www.shangbaoindonesia.com";
    public static final String NATIONTHAILAND_DOMAIN = "www.nationthailand.com";
    public static final String UDNBKK_DOMAIN = "www.udnbkk.com";
    public static final String PHILSTAR_DOMAIN = "www.philstar.com";
    public static final String MBCN_DOMAIN = "mbcn.com.ph";
    public static final String VIETNAMPLUS_DOMAIN = "www.vietnamplus.vn";
    public static final String LAOEDAILY_DOMAIN = "laoedaily.com.la";


    //media
    public static final String WEB_PORTAL_MEDIA = "门户网站";
    public static final String GOVERNMENT_MEDIA = "党政机关";
    public static final String COLLEGE_MEDIA = "高校";
    public static final String BUSINESS_MEDIA = "企业";

    //sourcecode
    public static final int PEOPLE_CODE = 0;
    public static final int CHINADAILY_CODE = 1;
    public static final int GXNEWS_CODE = 2;
    public static final int XINHUANET_CODE = 3;
    public static final int BJNEWS__CODE = 4;
    public static final int CHINANEWS_CODE = 5;
    public static final int SINA_CODE = 6;
    public static final int GXRB_CODE = 7;
    public static final int NGZB_CODE = 8;
    public static final int SINCHEW_CODE = 9;
    public static final int MALAYSINAKINI_CODE = 10;
    public static final int JAKARTAGLOBE_CODE = 11;
    public static final int NHANDAN_CODE = 12;
    public static final int PASAXON_CODE = 13;
    public static final int DAILYDEMOCRACYTODAY_CODE = 14;
    public static final int MANILATIMES_CODE = 15;
    public static final int LEAGAL_AND_ECONOMY_MAGAZINE_CODE = 16;
    public static final int SOUTH_SCIENCE_PAGE_CODE = 17;
    public static final int KOHSAMTEPHEAP_DAILY_CODE = 18;
    public static final int SHANGBAO_CODE = 19;
    public static final int BRUNEITOURISM_CODE = 20;
    public static final int KOMPAS_CODE = 21;
    public static final int BALITA_CODE = 22;
    public static final int THAIRATH_CODE = 23;
    public static final int BERITAHARIAN_CODE = 24;
    public static final int MOF_GOV_CODE = 25;
    public static final int GXZF_GOV_CODE = 26;
    public static final int GXUFE_EDU_CODE = 27;
    public static final int GXU_EDU_CODE = 28;
    public static final int CTRIP_CODE = 29;
    public static final int NANNING_GOV_CODE = 30;
    public static final int LIUZHOU_GOV_CODE = 31;
    public static final int GUILIN_GOV_CODE = 32;
    public static final int GXSTNU_EDU_CODE = 33;
    public static final int GXTCMU_EDU_CODE = 34;
    public static final int GXNU_EDU_CODE = 35;
    public static final int GUOJIRIBAO_CODE = 36;
    public static final int DAILYEXPRESS_CODE = 37;
    public static final int TUOITRE_CODE = 38;
    public static final int KPL_GOV_CODE = 39;
    public static final int DAILYNEWS_CODE = 40;
    public static final int HUANQIU_CODE = 41;
    public static final int GLTU_EDU_CODE = 42;
    public static final int GLIET_EDU_CODE = 43;
    public static final int GXUWZ_EDU_CODE = 44;
    public static final int WUZHOU_GOV_CODE = 45;
    public static final int GXHZ_GOV_CODE = 46;
    public static final int YULIN_GOV_CODE = 47;
    public static final int THEBORNEOPOST_CODE = 48;
    public static final int ENANYANG_CODE = 49;
    public static final int SHANGBAOINDONESIA_DOMAIN_CODE = 50;
    public static final int NATIONTHAILAND_CODE = 51;
    public static final int UDNBKK_CODE = 52;
    public static final int PHILSTAR_CODE = 53;
    public static final int MBCN_CODE = 54;
    public static final int VIETNAMPLUS_CODE = 55;
    public static final int LAOEDAILY_CODE = 56;

    //platform
    public static final String WEBSITE_PLATFORM = "网页";

    //SOURCE
    public static final String PEOPLE_DAILY_SOURCE = "人民日报";
    public static final String CHINA_DAILY_SOURCE = "中国日报";
    public static final String HUANQIU_SOURCE = "环球日报";
    public static final String GXNEWS_SOURCE = "广西新闻网";
    public static final String XINHUANET_SOURCE = "新华社";
    public static final String BJNEWS_SOURCE = "新京报";
    public static final String CHINANEWS_SOURCE = "中国新闻网";
    public static final String SINA_SOURCE = "新浪网";
    public static final String GXRB_SOURCE = "广西日报";
    public static final String NGZB_SOURCE = "南国早报";
    public static final String SINCHEW_SOURCE = "星洲日报";
    public static final String MALAYSINAKINI_SOURCE = "当今大马";
    public static final String JAKARTAGLOBE_SOURCE = "雅加达环球报";
    public static final String NHANDAN_SOURCE = "越南人民报";
    public static final String PASAXON_SOURCE = "老挝人民报";
    public static final String DAILYDEMOCRACYTODAY_SOURCE = "缅甸民主日报";
    public static final String MANILATIMES_SOURCE = "马尼拉时报";
    public static final String LEAGAL_AND_ECONOMY_MAGAZINE_SOURCE = "法制与经济杂志";
    public static final String SOUTH_SCIENCE_PAGE_SOURCE = "南方科技报";
    public static final String KOHSAMTEPHEAP_DAILY_SOURCE = "和平岛报";
    public static final String SHANGBAO_SOURCE = "菲律宾商报";
    public static final String BRUNEITOURISM_SOURCE = "文莱旅游局";
    public static final String KOMPAS_SOURCE = "罗盘报";
    public static final String BALITA_SOURCE = "巴利塔";
    public static final String THAIRATH_SOURCE = "泰叻报";
    public static final String BERITAHARIAN_SOURCE = "每日新闻报";
    public static final String MOF_GOV_SOURCE = "东帝汶财政部";
    public static final String GXZF_GOV_SOURCE = "广西壮族自治区人民政府";
    public static final String GXUFE_EDU_SOURCE = "广西财经学院";
    public static final String GXU_EDU_SOURCE = "广西大学";
    public static final String CTRIP_SOURCE = "携程网";
    public static final String NANNING_GOV_SOURCE = "南宁市人民政府";
    public static final String LIUZHOU_GOV_SOURCE = "柳州市人民政府";
    public static final String GUILIN_GOV_SOURCE = "桂林市人民政府";
    public static final String GXSTNU_EDU_SOURCE = "广西科技师范学院";
    public static final String GXTCMU_EDU_SOURCE = "广西中医药大学";
    public static final String GXNU_EDU_SOURCE = "广西师范大学";
    public static final String GUOJIRIBAO_SOURCE = "印度尼西亚国际日报";
    public static final String DAILYEXPRESS_SOURCE = "马来西亚《每日快报》";
    public static final String TUOITRE_SOURCE = "越南《青年报》";
    public static final String KPL_GOV_SOURCE = "《巴特寮报》";
    public static final String DAILYNEWS_SOURCE = "泰国《每日新闻》";
    public static final String GLTU_EDU_SOURCE = "桂林旅游学院";
    public static final String GLIET_EDU_SOURCE = "桂林电子科技大学";
    public static final String GXUWZ_EDU_SOURCE = "梧州学院";
    public static final String WUZHOU_GOV_SOURCE = "梧州市人民政府";
    public static final String GXHZ_GOV_SOURCE = "贺州市人民政府";
    public static final String YULIN_GOV_SOURCE = "玉林市人民政府";
    public static final String THEBORNEOPOST_SOURCE = "马来西亚《婆罗洲邮报》";
    public static final String ENANYANG_SOURCE = "马来西亚南洋商报";
    public static final String SHANGBAOINDONESIA_DOMAIN_SOURCE = "《印度尼西亚商报》";
    public static final String NATIONTHAILAND_SOURCE = "泰国《国家报》";
    public static final String UDNBKK_SOURCE = "泰国《世界日报》";
    public static final String PHILSTAR_SOURCE = "菲律宾星报";
    public static final String MBCN_SOURCE = "马尼拉公报 - 中文网";
    public static final String VIETNAMPLUS_SOURCE = "越南通讯社";
    public static final String LAOEDAILY_SOURCE = "经济贸易报";

    public static final String CHINA = "中国";
    public static final String MALAYSIA = "马来西亚";
    public static final String INDONESIA = "印尼";
    public static final String VIETNAM = "越南";
    public static final String LAOS = "老挝";
    public static final String BURMA = "缅甸";
    public static final String PHILIPPINES = "菲律宾";
    public static final String CAMBODIA = "柬埔寨";
    public static final String BRUNEI = "文莱";
    public static final String THAILAND = "泰国";
    public static final String SINGAPORE = "新加坡";
    public static final String EASTTIMOR = "东帝汶";

    // 爬虫框架
    public static final String PARSER_WEBCOLLECTOR_GENERAL = "webCollector_general";

    // 解析器
    public static final String EXTRACTOR_NEWS = "newsExtractor";

    // 爬虫状态
    public static final byte CRAWL_STATUS_UNSTART = 1;      // 未开始
    public static final byte CRAWL_STATUS_CRAWLING = 2;     // 爬取中
    public static final byte CRAWL_STATUS_COMPLETE = 3;     // 已完成
    public static final byte CRAWL_STATUS_STOP = 4;         // 已停用

    public static String getCountry(String domain) {
        return countryMap.get(domain);
    }

    public static String getLan(String domain) {
        return lanMap.get(domain);
    }

    public static String getMedia(String domain) {
        return mediaMap.get(domain);
    }

    public static String getSourceCode(String domain) {
        return sourceCodeMap.get(domain);
    }

    public static String getPlatform(String domain) {
        return platformMap.get(domain);
    }

    public static String getSource(String domain) {
        return sourceMap.get(domain);
    }

    public static String getCity(String curDomain) {
        return cityMap.get(curDomain);
    }

    public static String getProvince(String domain) {
        return provinceMap.get(domain);
    }

    static {
        //国家添加
        countryMap.put(PEOPLE_WEBSITE_DOMAIN, CHINA);
        countryMap.put(CHINADAILY_DOMAIN, CHINA);
        countryMap.put(HUANQIU_DOMAIN, CHINA);
        countryMap.put(GXNEWS_DOMAIN, CHINA);
        countryMap.put(XINHUANET_DOMAIN, CHINA);
        countryMap.put(BJNEWS_DOMAIN, CHINA);
        countryMap.put(CHINANEWS_DOMAIN, CHINA);
        countryMap.put(SINA_DOMAIN, CHINA);
        countryMap.put(GXRB_DOMAIN, CHINA);
        countryMap.put(NGZB_DOMAIN, CHINA);
        countryMap.put(SINCHEW_DOMAIN, MALAYSIA);
        countryMap.put(MALAYSINAKINI_DOMAIN, MALAYSIA);
        countryMap.put(JAKARTAGLOBE_DOMAIN, INDONESIA);
        countryMap.put(NHANDAN_DOMAIN, VIETNAM);
        countryMap.put(PASAXON_DOMAIN, LAOS);
        countryMap.put(DAILYDEMOCRACYTODAY_DOMAIN, BURMA);
        countryMap.put(MANILATIMES_DOMAIN, PHILIPPINES);
        countryMap.put(LEAGAL_AND_ECONOMY_MAGAZINE_DOMAIN, CHINA);
        countryMap.put(KOHSAMTEPHEAP_DAILY_DOMAIN, CAMBODIA);
        countryMap.put(SHANGBAO_DOMAIN, PHILIPPINES);
        countryMap.put(BRUNEITOURISM_DOMAIN, BRUNEI);
        countryMap.put(KOMPAS_DOMAIN, INDONESIA);
        countryMap.put(BALITA_DOMAIN, PHILIPPINES);
        countryMap.put(THAIRATH_DOMAIN, THAILAND);
        countryMap.put(BERITAHARIAN_DOMAIN, SINGAPORE);
        countryMap.put(MOF_GOV_DOMAIN, EASTTIMOR);
        countryMap.put(GXZF_GOV_DOMAIN, CHINA);
        countryMap.put(GXUFE_EDU_DOMAIN, CHINA);
        countryMap.put(GXU_EDU_DOMAIN, CHINA);
        countryMap.put(CTRIP_DOMAIN, CHINA);
        countryMap.put(NANNING_GOV_DOMAIN, CHINA);
        countryMap.put(LIUZHOU_GOV_DOMAIN, CHINA);
        countryMap.put(GUILIN_GOV_DOMAIN, CHINA);
        countryMap.put(GXSTNU_EDU_DOMAIN, CHINA);
        countryMap.put(GXTCMU_EDU_DOMAIN, CHINA);
        countryMap.put(GXNU_EDU_DOMAIN, CHINA);
        countryMap.put(GUOJIRIBAO_DOMAIN, INDONESIA);
        countryMap.put(DAILYEXPRESS_DOMAIN, MALAYSIA);
        countryMap.put(TUOITRE_DOMAIN, VIETNAM);
        countryMap.put(KPL_GOV_DOMAIN, LAOS);
        countryMap.put(DAILYNEWS_DOMAIN, THAILAND);
        countryMap.put(GLTU_EDU_DOMAIN, CHINA);
        countryMap.put(GLIET_EDU_DOMAIN, CHINA);
        countryMap.put(GXUWZ_EDU_DOMAIN, CHINA);
        countryMap.put(WUZHOU_GOV_DOMAIN, CHINA);
        countryMap.put(GXHZ_GOV_DOMAIN, CHINA);
        countryMap.put(YULIN_GOV_DOMAIN, CHINA);

        countryMap.put(THEBORNEOPOST_DOMAIN, MALAYSIA);
        countryMap.put(ENANYANG_DOMAIN, MALAYSIA);
        countryMap.put(SHANGBAOINDONESIA_DOMAIN, INDONESIA);
        countryMap.put(NATIONTHAILAND_DOMAIN, THAILAND);
        countryMap.put(UDNBKK_DOMAIN, THAILAND);
        countryMap.put(PHILSTAR_DOMAIN, PHILIPPINES);
        countryMap.put(MBCN_DOMAIN, PHILIPPINES);
        countryMap.put(VIETNAMPLUS_DOMAIN, VIETNAM);
        countryMap.put(LAOEDAILY_DOMAIN, LAOS);

        //语言选择
        lanMap.put(PEOPLE_WEBSITE_DOMAIN, LAN_ZH);
        lanMap.put(BALITA_DOMAIN, LAN_FIL);
        lanMap.put(THAIRATH_DOMAIN, LAN_TH);
        lanMap.put(BERITAHARIAN_DOMAIN, LAN_MS);
        lanMap.put(MOF_GOV_DOMAIN, LAN_PT);
        lanMap.put(GXZF_GOV_DOMAIN, LAN_ZH);
        lanMap.put(GXUFE_EDU_DOMAIN, LAN_ZH);
        lanMap.put(GXU_EDU_DOMAIN, LAN_ZH);
        lanMap.put(CTRIP_DOMAIN, LAN_ZH);
        lanMap.put(NANNING_GOV_DOMAIN, LAN_ZH);
        lanMap.put(LIUZHOU_GOV_DOMAIN, LAN_ZH);
        lanMap.put(GUILIN_GOV_DOMAIN, LAN_ZH);
        lanMap.put(GXSTNU_EDU_DOMAIN, LAN_ZH);
        lanMap.put(GXTCMU_EDU_DOMAIN, LAN_ZH);
        lanMap.put(GXNU_EDU_DOMAIN, LAN_ZH);
        lanMap.put(GUOJIRIBAO_DOMAIN, LAN_ZH);
        lanMap.put(DAILYEXPRESS_DOMAIN, LAN_EN);
        lanMap.put(TUOITRE_DOMAIN, LAN_VI);
        lanMap.put(KPL_GOV_DOMAIN, LAN_LO);
        lanMap.put(DAILYNEWS_DOMAIN, LAN_TH);

        lanMap.put(GLTU_EDU_DOMAIN, LAN_ZH);
        lanMap.put(GLIET_EDU_DOMAIN, LAN_ZH);
        lanMap.put(GXUWZ_EDU_DOMAIN, LAN_ZH);

        lanMap.put(WUZHOU_GOV_DOMAIN, LAN_ZH);
        lanMap.put(GXHZ_GOV_DOMAIN, LAN_ZH);
        lanMap.put(YULIN_GOV_DOMAIN, LAN_ZH);

        lanMap.put(PEOPLE_WEBSITE_DOMAIN, LAN_ZH);
        lanMap.put(PEOPLE_WEBSITE_DOMAIN, LAN_ZH);
        lanMap.put(PEOPLE_WEBSITE_DOMAIN, LAN_ZH);
        lanMap.put(CHINADAILY_DOMAIN, LAN_ZH);
        lanMap.put(HUANQIU_DOMAIN, LAN_ZH);
        lanMap.put(GXNEWS_DOMAIN, LAN_ZH);
        lanMap.put(XINHUANET_DOMAIN, LAN_ZH);
        lanMap.put(BJNEWS_DOMAIN, LAN_ZH);
        lanMap.put(CHINANEWS_DOMAIN, LAN_ZH);
        lanMap.put(SINA_DOMAIN, LAN_ZH);
        lanMap.put(GXRB_DOMAIN, LAN_ZH);
        lanMap.put(NGZB_DOMAIN, LAN_ZH);
        lanMap.put(SINCHEW_DOMAIN, LAN_EN);
        lanMap.put(MALAYSINAKINI_DOMAIN, LAN_EN);
        lanMap.put(JAKARTAGLOBE_DOMAIN, LAN_EN);
        lanMap.put(NHANDAN_DOMAIN, LAN_VI);
        lanMap.put(PASAXON_DOMAIN, LAN_LO);
        lanMap.put(DAILYDEMOCRACYTODAY_DOMAIN, LAN_MY);
        lanMap.put(MANILATIMES_DOMAIN, LAN_EN);
        lanMap.put(LEAGAL_AND_ECONOMY_MAGAZINE_DOMAIN, LAN_ZH);
        lanMap.put(KOHSAMTEPHEAP_DAILY_DOMAIN, LAN_KM);
        lanMap.put(SHANGBAO_DOMAIN, LAN_ZH);
        lanMap.put(BRUNEITOURISM_DOMAIN, LAN_EN);
        lanMap.put(KOMPAS_DOMAIN, LAN_ID);

        lanMap.put(THEBORNEOPOST_DOMAIN, LAN_EN);
        lanMap.put(ENANYANG_DOMAIN, LAN_ZH);
        lanMap.put(SHANGBAOINDONESIA_DOMAIN, LAN_ZH);
        lanMap.put(NATIONTHAILAND_DOMAIN, LAN_EN);
        lanMap.put(UDNBKK_DOMAIN, LAN_ZH);
        lanMap.put(PHILSTAR_DOMAIN, LAN_EN);
        lanMap.put(MBCN_DOMAIN, LAN_ZH);
        lanMap.put(VIETNAMPLUS_DOMAIN, LAN_VI);
        lanMap.put(LAOEDAILY_DOMAIN, LAN_LO);

        //中国新闻网


        //media
        mediaMap.put(PEOPLE_WEBSITE_DOMAIN, WEB_PORTAL_MEDIA);
        mediaMap.put(CHINADAILY_DOMAIN, WEB_PORTAL_MEDIA);
        mediaMap.put(HUANQIU_DOMAIN, WEB_PORTAL_MEDIA);
        mediaMap.put(GXNEWS_DOMAIN, WEB_PORTAL_MEDIA);
        mediaMap.put(XINHUANET_DOMAIN, WEB_PORTAL_MEDIA);
        mediaMap.put(BJNEWS_DOMAIN, WEB_PORTAL_MEDIA);
        mediaMap.put(CHINANEWS_DOMAIN, WEB_PORTAL_MEDIA);
        mediaMap.put(SINA_DOMAIN, WEB_PORTAL_MEDIA);
        mediaMap.put(GXRB_DOMAIN, WEB_PORTAL_MEDIA);
        mediaMap.put(NGZB_DOMAIN, WEB_PORTAL_MEDIA);
        mediaMap.put(SINCHEW_DOMAIN, WEB_PORTAL_MEDIA);
        mediaMap.put(MALAYSINAKINI_DOMAIN, WEB_PORTAL_MEDIA);
        mediaMap.put(JAKARTAGLOBE_DOMAIN, WEB_PORTAL_MEDIA);
        mediaMap.put(NHANDAN_DOMAIN, WEB_PORTAL_MEDIA);
        mediaMap.put(PASAXON_DOMAIN, WEB_PORTAL_MEDIA);
        mediaMap.put(DAILYDEMOCRACYTODAY_DOMAIN, WEB_PORTAL_MEDIA);
        mediaMap.put(MANILATIMES_DOMAIN, WEB_PORTAL_MEDIA);
        mediaMap.put(LEAGAL_AND_ECONOMY_MAGAZINE_DOMAIN, WEB_PORTAL_MEDIA);
        mediaMap.put(KOHSAMTEPHEAP_DAILY_DOMAIN, WEB_PORTAL_MEDIA);
        mediaMap.put(SHANGBAO_DOMAIN, WEB_PORTAL_MEDIA);
        mediaMap.put(BRUNEITOURISM_DOMAIN, WEB_PORTAL_MEDIA);
        mediaMap.put(KOMPAS_DOMAIN, WEB_PORTAL_MEDIA);
        mediaMap.put(BALITA_DOMAIN, WEB_PORTAL_MEDIA);
        mediaMap.put(THAIRATH_DOMAIN, WEB_PORTAL_MEDIA);
        mediaMap.put(BERITAHARIAN_DOMAIN, WEB_PORTAL_MEDIA);
        mediaMap.put(MOF_GOV_DOMAIN, GOVERNMENT_MEDIA);
        mediaMap.put(GXZF_GOV_DOMAIN, GOVERNMENT_MEDIA);
        mediaMap.put(GXUFE_EDU_DOMAIN, COLLEGE_MEDIA);
        mediaMap.put(GXU_EDU_DOMAIN, COLLEGE_MEDIA);
        mediaMap.put(CTRIP_DOMAIN, WEB_PORTAL_MEDIA);
        mediaMap.put(NANNING_GOV_DOMAIN, GOVERNMENT_MEDIA);
        mediaMap.put(LIUZHOU_GOV_DOMAIN, GOVERNMENT_MEDIA);
        mediaMap.put(GUILIN_GOV_DOMAIN, GOVERNMENT_MEDIA);
        mediaMap.put(GXSTNU_EDU_DOMAIN, COLLEGE_MEDIA);
        mediaMap.put(GXTCMU_EDU_DOMAIN, COLLEGE_MEDIA);
        mediaMap.put(GXNU_EDU_DOMAIN, COLLEGE_MEDIA);
        mediaMap.put(GLTU_EDU_DOMAIN, COLLEGE_MEDIA);
        mediaMap.put(GLIET_EDU_DOMAIN, COLLEGE_MEDIA);
        mediaMap.put(GXUWZ_EDU_DOMAIN, COLLEGE_MEDIA);
        mediaMap.put(GUOJIRIBAO_DOMAIN, WEB_PORTAL_MEDIA);
        mediaMap.put(DAILYEXPRESS_DOMAIN, WEB_PORTAL_MEDIA);
        mediaMap.put(TUOITRE_DOMAIN, WEB_PORTAL_MEDIA);
        mediaMap.put(KPL_GOV_DOMAIN, WEB_PORTAL_MEDIA);
        mediaMap.put(DAILYNEWS_DOMAIN, WEB_PORTAL_MEDIA);
        mediaMap.put(WUZHOU_GOV_DOMAIN, GOVERNMENT_MEDIA);
        mediaMap.put(GXHZ_GOV_DOMAIN, GOVERNMENT_MEDIA);
        mediaMap.put(YULIN_GOV_DOMAIN, GOVERNMENT_MEDIA);

        mediaMap.put(THEBORNEOPOST_DOMAIN, WEB_PORTAL_MEDIA);
        mediaMap.put(ENANYANG_DOMAIN, WEB_PORTAL_MEDIA);
        mediaMap.put(SHANGBAOINDONESIA_DOMAIN, WEB_PORTAL_MEDIA);
        mediaMap.put(NATIONTHAILAND_DOMAIN, WEB_PORTAL_MEDIA);
        mediaMap.put(UDNBKK_DOMAIN, WEB_PORTAL_MEDIA);
        mediaMap.put(PHILSTAR_DOMAIN, WEB_PORTAL_MEDIA);
        mediaMap.put(MBCN_DOMAIN, WEB_PORTAL_MEDIA);
        mediaMap.put(VIETNAMPLUS_DOMAIN, WEB_PORTAL_MEDIA);
        mediaMap.put(LAOEDAILY_DOMAIN, WEB_PORTAL_MEDIA);

        //sourceCode
        sourceCodeMap.put(PEOPLE_WEBSITE_DOMAIN, String.valueOf(PEOPLE_CODE));
        sourceCodeMap.put(CHINADAILY_DOMAIN, String.valueOf(CHINADAILY_CODE));
        sourceCodeMap.put(HUANQIU_DOMAIN, String.valueOf(HUANQIU_CODE));
        sourceCodeMap.put(GXNEWS_DOMAIN, String.valueOf(GXNEWS_CODE));
        sourceCodeMap.put(XINHUANET_DOMAIN, String.valueOf(XINHUANET_CODE));
        sourceCodeMap.put(BJNEWS_DOMAIN, String.valueOf(BJNEWS__CODE));
        sourceCodeMap.put(CHINANEWS_DOMAIN, String.valueOf(CHINANEWS_CODE));
        sourceCodeMap.put(SINA_DOMAIN, String.valueOf(SINA_CODE));
        sourceCodeMap.put(GXRB_DOMAIN, String.valueOf(GXRB_CODE));
        sourceCodeMap.put(NGZB_DOMAIN, String.valueOf(NGZB_CODE));
        sourceCodeMap.put(SINCHEW_DOMAIN, String.valueOf(SINCHEW_CODE));
        sourceCodeMap.put(MALAYSINAKINI_DOMAIN, String.valueOf(MALAYSINAKINI_CODE));
        sourceCodeMap.put(JAKARTAGLOBE_DOMAIN, String.valueOf(JAKARTAGLOBE_CODE));
        sourceCodeMap.put(NHANDAN_DOMAIN, String.valueOf(NHANDAN_CODE));
        sourceCodeMap.put(PASAXON_DOMAIN, String.valueOf(PASAXON_CODE));
        sourceCodeMap.put(DAILYDEMOCRACYTODAY_DOMAIN, String.valueOf(DAILYDEMOCRACYTODAY_CODE));
        sourceCodeMap.put(MANILATIMES_DOMAIN, String.valueOf(MANILATIMES_CODE));
        sourceCodeMap.put(LEAGAL_AND_ECONOMY_MAGAZINE_DOMAIN, String.valueOf(LEAGAL_AND_ECONOMY_MAGAZINE_CODE));
        sourceCodeMap.put(SOUTH_SCIENCE_PAGE_DOMAIN, String.valueOf(SOUTH_SCIENCE_PAGE_CODE));
        sourceCodeMap.put(KOHSAMTEPHEAP_DAILY_DOMAIN, String.valueOf(KOHSAMTEPHEAP_DAILY_CODE));
        sourceCodeMap.put(SHANGBAO_DOMAIN, String.valueOf(SHANGBAO_CODE));
        sourceCodeMap.put(BRUNEITOURISM_DOMAIN, String.valueOf(BRUNEITOURISM_CODE));
        sourceCodeMap.put(KOMPAS_DOMAIN, String.valueOf(KOMPAS_CODE));
        sourceCodeMap.put(BALITA_DOMAIN, String.valueOf(BALITA_CODE));
        sourceCodeMap.put(THAIRATH_DOMAIN, String.valueOf(THAIRATH_CODE));
        sourceCodeMap.put(BERITAHARIAN_DOMAIN, String.valueOf(BERITAHARIAN_CODE));
        sourceCodeMap.put(MOF_GOV_DOMAIN, String.valueOf(MOF_GOV_CODE));
        sourceCodeMap.put(GXZF_GOV_DOMAIN, String.valueOf(GXZF_GOV_CODE));
        sourceCodeMap.put(GXUFE_EDU_DOMAIN, String.valueOf(GXUFE_EDU_CODE));
        sourceCodeMap.put(GXU_EDU_DOMAIN, String.valueOf(GXU_EDU_CODE));
        sourceCodeMap.put(CTRIP_DOMAIN, String.valueOf(CTRIP_CODE));
        sourceCodeMap.put(NANNING_GOV_DOMAIN, String.valueOf(NANNING_GOV_CODE));
        sourceCodeMap.put(LIUZHOU_GOV_DOMAIN, String.valueOf(LIUZHOU_GOV_CODE));
        sourceCodeMap.put(GUILIN_GOV_DOMAIN, String.valueOf(GUILIN_GOV_CODE));
        sourceCodeMap.put(GXSTNU_EDU_DOMAIN, String.valueOf(GXSTNU_EDU_CODE));
        sourceCodeMap.put(GXTCMU_EDU_DOMAIN, String.valueOf(GXTCMU_EDU_CODE));
        sourceCodeMap.put(GXNU_EDU_DOMAIN, String.valueOf(GXNU_EDU_CODE));
        sourceCodeMap.put(GUOJIRIBAO_DOMAIN, String.valueOf(GUOJIRIBAO_CODE));
        sourceCodeMap.put(DAILYEXPRESS_DOMAIN, String.valueOf(DAILYEXPRESS_CODE));
        sourceCodeMap.put(TUOITRE_DOMAIN, String.valueOf(TUOITRE_CODE));
        sourceCodeMap.put(KPL_GOV_DOMAIN, String.valueOf(KPL_GOV_CODE));
        sourceCodeMap.put(DAILYNEWS_DOMAIN, String.valueOf(DAILYNEWS_CODE));
        sourceCodeMap.put(GLTU_EDU_DOMAIN, String.valueOf(GLTU_EDU_CODE));
        sourceCodeMap.put(GLIET_EDU_DOMAIN, String.valueOf(GLIET_EDU_CODE));
        sourceCodeMap.put(GXUWZ_EDU_DOMAIN, String.valueOf(GXUWZ_EDU_CODE));
        sourceCodeMap.put(WUZHOU_GOV_DOMAIN, String.valueOf(WUZHOU_GOV_CODE));
        sourceCodeMap.put(GXHZ_GOV_DOMAIN, String.valueOf(GXHZ_GOV_CODE));
        sourceCodeMap.put(YULIN_GOV_DOMAIN, String.valueOf(YULIN_GOV_CODE));

        sourceCodeMap.put(THEBORNEOPOST_DOMAIN, String.valueOf(THEBORNEOPOST_CODE));
        sourceCodeMap.put(ENANYANG_DOMAIN, String.valueOf(ENANYANG_CODE));
        sourceCodeMap.put(SHANGBAOINDONESIA_DOMAIN, String.valueOf(SHANGBAOINDONESIA_DOMAIN_CODE));
        sourceCodeMap.put(NATIONTHAILAND_DOMAIN, String.valueOf(NATIONTHAILAND_CODE));
        sourceCodeMap.put(UDNBKK_DOMAIN, String.valueOf(UDNBKK_CODE));
        sourceCodeMap.put(PHILSTAR_DOMAIN, String.valueOf(PHILSTAR_CODE));
        sourceCodeMap.put(MBCN_DOMAIN, String.valueOf(MBCN_CODE));
        sourceCodeMap.put(VIETNAMPLUS_DOMAIN, String.valueOf(VIETNAMPLUS_CODE));
        sourceCodeMap.put(LAOEDAILY_DOMAIN, String.valueOf(LAOEDAILY_CODE));

        //platformMap
        platformMap.put(PEOPLE_WEBSITE_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(CHINADAILY_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(HUANQIU_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(GXNEWS_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(XINHUANET_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(BJNEWS_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(CHINANEWS_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(SINA_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(GXRB_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(NGZB_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(SINCHEW_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(MALAYSINAKINI_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(JAKARTAGLOBE_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(NHANDAN_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(PASAXON_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(DAILYDEMOCRACYTODAY_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(MANILATIMES_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(LEAGAL_AND_ECONOMY_MAGAZINE_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(KOHSAMTEPHEAP_DAILY_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(SHANGBAO_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(BRUNEITOURISM_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(KOMPAS_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(BALITA_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(THAIRATH_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(BERITAHARIAN_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(MOF_GOV_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(GXZF_GOV_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(GXUFE_EDU_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(GXU_EDU_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(CTRIP_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(NANNING_GOV_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(LIUZHOU_GOV_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(GUILIN_GOV_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(GXSTNU_EDU_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(GXTCMU_EDU_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(GXNU_EDU_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(GUOJIRIBAO_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(DAILYEXPRESS_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(TUOITRE_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(KPL_GOV_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(DAILYNEWS_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(GLTU_EDU_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(GLIET_EDU_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(GXUWZ_EDU_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(WUZHOU_GOV_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(GXHZ_GOV_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(YULIN_GOV_DOMAIN, WEBSITE_PLATFORM);

        platformMap.put(THEBORNEOPOST_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(ENANYANG_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(SHANGBAOINDONESIA_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(NATIONTHAILAND_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(UDNBKK_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(PHILSTAR_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(MBCN_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(VIETNAMPLUS_DOMAIN, WEBSITE_PLATFORM);
        platformMap.put(LAOEDAILY_DOMAIN, WEBSITE_PLATFORM);

        //sourceMap
        sourceMap.put(PEOPLE_WEBSITE_DOMAIN, PEOPLE_DAILY_SOURCE);
        sourceMap.put(CHINADAILY_DOMAIN, CHINA_DAILY_SOURCE);
        sourceMap.put(HUANQIU_DOMAIN, HUANQIU_SOURCE);
        sourceMap.put(GXNEWS_DOMAIN, GXNEWS_SOURCE);
        sourceMap.put(XINHUANET_DOMAIN, XINHUANET_SOURCE);
        sourceMap.put(BJNEWS_DOMAIN, BJNEWS_SOURCE);
        sourceMap.put(CHINANEWS_DOMAIN, CHINANEWS_SOURCE);
        sourceMap.put(SINA_DOMAIN, SINA_SOURCE);
        sourceMap.put(GXRB_DOMAIN, GXRB_SOURCE);
        sourceMap.put(NGZB_DOMAIN, NGZB_SOURCE);
        sourceMap.put(SINCHEW_DOMAIN, SINCHEW_SOURCE);
        sourceMap.put(MALAYSINAKINI_DOMAIN, MALAYSINAKINI_SOURCE);
        sourceMap.put(JAKARTAGLOBE_DOMAIN, JAKARTAGLOBE_SOURCE);
        sourceMap.put(NHANDAN_DOMAIN, NHANDAN_SOURCE);
        sourceMap.put(PASAXON_DOMAIN, PASAXON_SOURCE);
        sourceMap.put(DAILYDEMOCRACYTODAY_DOMAIN, DAILYDEMOCRACYTODAY_SOURCE);
        sourceMap.put(MANILATIMES_DOMAIN, MANILATIMES_SOURCE);
        sourceMap.put(LEAGAL_AND_ECONOMY_MAGAZINE_DOMAIN, LEAGAL_AND_ECONOMY_MAGAZINE_SOURCE);
        sourceMap.put(KOHSAMTEPHEAP_DAILY_DOMAIN, KOHSAMTEPHEAP_DAILY_SOURCE);
        sourceMap.put(SHANGBAO_DOMAIN, SHANGBAO_SOURCE);
        sourceMap.put(BRUNEITOURISM_DOMAIN, BRUNEITOURISM_SOURCE);
        sourceMap.put(KOMPAS_DOMAIN, KOMPAS_SOURCE);
        sourceMap.put(BALITA_DOMAIN, BALITA_SOURCE);
        sourceMap.put(THAIRATH_DOMAIN, THAIRATH_SOURCE);
        sourceMap.put(BERITAHARIAN_DOMAIN, BERITAHARIAN_SOURCE);
        sourceMap.put(MOF_GOV_DOMAIN, MOF_GOV_SOURCE);
        sourceMap.put(GXZF_GOV_DOMAIN, GXZF_GOV_SOURCE);
        sourceMap.put(GXUFE_EDU_DOMAIN, GXUFE_EDU_SOURCE);
        sourceMap.put(GXU_EDU_DOMAIN, GXU_EDU_SOURCE);
        sourceMap.put(CTRIP_DOMAIN, CTRIP_SOURCE);
        sourceMap.put(NANNING_GOV_DOMAIN, NANNING_GOV_SOURCE);
        sourceMap.put(LIUZHOU_GOV_DOMAIN, LIUZHOU_GOV_SOURCE);
        sourceMap.put(GUILIN_GOV_DOMAIN, GUILIN_GOV_SOURCE);
        sourceMap.put(GXSTNU_EDU_DOMAIN, GXSTNU_EDU_SOURCE);
        sourceMap.put(GXTCMU_EDU_DOMAIN, GXTCMU_EDU_SOURCE);
        sourceMap.put(GXNU_EDU_DOMAIN, GXNU_EDU_SOURCE);
        sourceMap.put(GUOJIRIBAO_DOMAIN, GUOJIRIBAO_SOURCE);
        sourceMap.put(DAILYEXPRESS_DOMAIN, DAILYEXPRESS_SOURCE);
        sourceMap.put(TUOITRE_DOMAIN, TUOITRE_SOURCE);
        sourceMap.put(KPL_GOV_DOMAIN, KPL_GOV_SOURCE);
        sourceMap.put(DAILYNEWS_DOMAIN, DAILYNEWS_SOURCE);
        sourceMap.put(GLTU_EDU_DOMAIN, GLTU_EDU_SOURCE);
        sourceMap.put(GLIET_EDU_DOMAIN, GLIET_EDU_SOURCE);
        sourceMap.put(GXUWZ_EDU_DOMAIN, GXUWZ_EDU_SOURCE);
        sourceMap.put(WUZHOU_GOV_DOMAIN, WUZHOU_GOV_SOURCE);
        sourceMap.put(GXHZ_GOV_DOMAIN, GXHZ_GOV_SOURCE);
        sourceMap.put(YULIN_GOV_DOMAIN, YULIN_GOV_SOURCE);

        sourceMap.put(THEBORNEOPOST_DOMAIN, THEBORNEOPOST_SOURCE);
        sourceMap.put(ENANYANG_DOMAIN, ENANYANG_SOURCE);
        sourceMap.put(SHANGBAOINDONESIA_DOMAIN, SHANGBAOINDONESIA_DOMAIN_SOURCE);
        sourceMap.put(NATIONTHAILAND_DOMAIN, NATIONTHAILAND_SOURCE);
        sourceMap.put(UDNBKK_DOMAIN, UDNBKK_SOURCE);
        sourceMap.put(PHILSTAR_DOMAIN, PHILSTAR_SOURCE);
        sourceMap.put(MBCN_DOMAIN, MBCN_SOURCE);
        sourceMap.put(VIETNAMPLUS_DOMAIN, VIETNAMPLUS_SOURCE);
        sourceMap.put(LAOEDAILY_DOMAIN, LAOEDAILY_SOURCE);

    }
}
