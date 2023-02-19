package com.dzbiao.springbootkafkaconsumer.service.impl;

import com.dzbiao.springbootkafkaconsumer.dao.SwitchLogMapper;
import com.dzbiao.springbootkafkaconsumer.entity.SwitchLog;
import com.dzbiao.springbootkafkaconsumer.service.ISwitchLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: dzbiao
 * @CreateTime: 2023/02/19 10:53
 * @Description:
 */
@Service
public class SwitchLogServiceImpl implements ISwitchLogService {

    @Resource
    private SwitchLogMapper switchLogMapper;

    /**
     *
     * @param switchLog
     * @return
     */
    @Override
    public int updateSwitchLog(SwitchLog switchLog) {
        return switchLogMapper.updateSwitchLog(switchLog);
    }
}
