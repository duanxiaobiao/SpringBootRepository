package com.dzbiao.easyexcel2.dao;

import com.dzbiao.easyexcel2.domain.entity.WiseMapDataMonitorEntity;
import com.dzbiao.easyexcel2.domain.param.MonitorParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: dzbiao
 * @CreateTime: 2023/01/20 17:19
 * @Description:
 */
@Mapper
public interface WiseMapMonitorMapper {

    List<WiseMapDataMonitorEntity> list(MonitorParam param);

}
