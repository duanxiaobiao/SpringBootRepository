package com.dzbiao.easyexcel2.service.impl.strategy;

import com.dzbiao.easyexcel2.domain.entity.WiseMapDataMonitorEntity;
import lombok.Data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: dzbiao
 * @CreateTime: 2023/01/20 22:45
 * @Description:
 */
@Data
public class MonitorStrategy {

    // 指定标红色的列
    private List<Integer> columns;

    // 指定批注
    private HashMap<Integer, String> annotationsMap;

    // 导出Excel的数据集
    private List<?> list ;

    //
    private Class aClass;


    public MonitorStrategy getMonitorStrategy(){
        return new MonitorStrategy();
    }


    public List<?> populationList(List<WiseMapDataMonitorEntity> list){
        return Arrays.asList();
    }
}
