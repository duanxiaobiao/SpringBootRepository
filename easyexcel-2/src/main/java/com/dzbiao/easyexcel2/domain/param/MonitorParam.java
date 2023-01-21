package com.dzbiao.easyexcel2.domain.param;

import lombok.Data;

import java.util.List;

/**
 * @Author: dzbiao
 * @CreateTime: 2023/01/20 12:36
 * @Description:
 */
@Data
public class MonitorParam {

    private Integer type;

    private String startTime;

    private String endTime;

    private List<Integer> excStatus;

    private MonitorSortParam sort;

}
