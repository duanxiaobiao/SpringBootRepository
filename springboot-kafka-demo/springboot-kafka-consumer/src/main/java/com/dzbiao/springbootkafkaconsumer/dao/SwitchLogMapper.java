package com.dzbiao.springbootkafkaconsumer.dao;

import com.dzbiao.springbootkafkaconsumer.entity.SwitchLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: dzbiao
 * @CreateTime: 2023/02/19 11:14
 * @Description:
 */
@Mapper
public interface SwitchLogMapper {

    /**
     * 更新
     * @param switchLog
     * @return
     */
    int updateSwitchLog(SwitchLog switchLog);
}
