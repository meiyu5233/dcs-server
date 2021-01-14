package com.tmxbase.dcsserver.base.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RawDoc implements Serializable {

    private String docId; // 数据id
    private String content; // 文章内容
    private String summary; // 文章摘要
    private String title; //  文章标题
    private String media; // 媒体类型
    private byte emotion; //  文章情感类型 positive=3 neutral=2 negative=1
    private String platform; // 文章所属平台
    private String source; //文章所属来源
    private String industry; //行业
    private String lan; // 文章所属语言
    private String href; // 文章来源页
    private String path; // 文章路径
    private String fileId; // 所属id
    private String country; // 文章来源国家
    private String time; // 文章发布时间
    private String modifyTime; // 文章入库时间
}
