package com.dzbiao.springbootkafkaconsumer.entity;

import lombok.Data;

/**
 * @author: dzbiao
 * @CreateTime: 2023/02/19 10:55
 * @Description:
 */
@Data
public class SwitchLog {

    /**
     * 自增ID
     */
    private Integer id ;

    /**
     * 索引名称
     */
    private String indexName;

    /**
     * 索引日期
     */
    private String indexDate;

    /**
     * 具体索引
     */
    private String indexNameDate;
}
