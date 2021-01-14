package com.tmxbase.dcsserver.base.constants;

import java.util.HashMap;
import java.util.Map;

public class IndustryMapper {

    private static Map<Integer, String> industryMap = new HashMap<>();

    static {
        industryMap.put(0, "体育(sport)");
        industryMap.put(1, "军事政治(military)");
        industryMap.put(2, "航天航空(aerospace)");
        industryMap.put(3, "汽车(car)");
        industryMap.put(4, "商业(business)");
        industryMap.put(5, "化学(chemistry)");
        industryMap.put(6, "建筑(construction)");
        industryMap.put(7, "文化(culture)");
        industryMap.put(8, "电子(electric)");
        industryMap.put(9, "金融(finance)");
        industryMap.put(10, "地质(geology)");
        industryMap.put(11, "计算机(it)");
        industryMap.put(12, "法律(law)");
        industryMap.put(13, "机械(mechanical)");
        industryMap.put(14, "医药(medicine)");
        industryMap.put(15, "旅游(tourism)");
    }

    public static String getIndustry(int industryCode) {
        return industryMap.get(industryCode);
    }
}
