package com.dzbiao.springbootkafkaconsumer.service;

import com.dzbiao.springbootkafkaconsumer.entity.SwitchLog;

/**
 * @author: dzbiao
 * @CreateTime: 2023/02/19 10:53
 * @Description:
 */
public interface ISwitchLogService {

    /**
     * 更新
     * @param switchLog
     * @return
     */
    int updateSwitchLog(SwitchLog switchLog);
}
