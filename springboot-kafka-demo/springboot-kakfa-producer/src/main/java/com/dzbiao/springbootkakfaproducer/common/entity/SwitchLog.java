package com.dzbiao.springbootkakfaproducer.common.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author: dzbiao
 * @CreateTime: 2023/02/18 10:13
 * @Description:
 */
@Builder
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
