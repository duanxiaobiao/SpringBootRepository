package com.dzbiao.easyexcel2.service;

import com.dzbiao.easyexcel2.domain.param.MonitorParam;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author: dzbiao
 * @CreateTime: 2023/01/20 12:35
 * @Description:
 */
public interface WiseMapMonitorService {


    void download(MonitorParam param, HttpServletResponse httpServletResponse);

}
