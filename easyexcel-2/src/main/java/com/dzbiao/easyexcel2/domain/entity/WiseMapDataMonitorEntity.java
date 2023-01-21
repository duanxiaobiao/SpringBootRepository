package com.dzbiao.easyexcel2.domain.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @Author: dzbiao
 * @CreateTime: 2023/01/20 17:06
 * @Description:
 */
@Slf4j
@Data
public class WiseMapDataMonitorEntity {

    private Integer id;

    private Integer type;

    private String typeName;

    private String name ;

    private String sourceName;

    private String indexDate;

    private Integer dataTotal;

    private double dataTotalRate;

    private Integer userTotal;

    private double userTotalRate;

    private JSONObject dataDetail;

    private double gpsCoverageRate;

    private double mauCoverageRate;

    private Integer isException;

    private String triggerCondition;

    private Integer channel ;

    private Date createTime;

    private Date updateTime;

    public void setDataDetail(String dataDetail) {
        try{
            this.dataDetail = JSONObject.parseObject(dataDetail);
        }catch (Exception e){
            this.dataDetail = new JSONObject();
            log.info("转换异常!");
        }
    }
}
