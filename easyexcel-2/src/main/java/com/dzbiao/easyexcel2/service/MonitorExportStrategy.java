package com.dzbiao.easyexcel2.service;

import com.dzbiao.easyexcel2.domain.entity.WiseMapDataMonitorEntity;
import com.dzbiao.easyexcel2.service.impl.strategy.MonitorStrategy;

import java.util.List;

/**
 * @Author: dzbiao
 * @CreateTime: 2023/01/20 18:14
 * @Description:
 */
public interface MonitorExportStrategy {


    public boolean monitorStrategy(Integer type);


    public MonitorStrategy population(List<WiseMapDataMonitorEntity> list);

}
