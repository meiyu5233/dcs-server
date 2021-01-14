package com.tmxbase.dcsserver.base.model;

import lombok.Data;

import java.util.Date;

/**
 * @Designation:
 * @Author: Ylz
 * @Date: 2019/10/11
 * @Version: 1.0
 */
@Data
public class Html {

    private String _id;
    private String domain;
    private String url;
    private String level;
    private String type;
    private String html;
    private Date creatTime;
}
