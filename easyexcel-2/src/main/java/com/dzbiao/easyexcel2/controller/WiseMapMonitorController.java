package com.dzbiao.easyexcel2.controller;

import com.dzbiao.easyexcel2.domain.param.MonitorParam;
import com.dzbiao.easyexcel2.service.WiseMapMonitorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: dzbiao
 * @CreateTime: 2023/01/20 12:33
 * @Description:
 */
@RestController
@RequestMapping("/web/monitor")
public class WiseMapMonitorController {

    @Resource
    private HttpServletResponse httpServletResponse;

    @Resource
    private WiseMapMonitorService wiseMapMonitorService;


    /**
     * 下载报表
     * @param param
     * @param httpServletResponse
     */
    @PostMapping("/download")
    public void download(@RequestBody MonitorParam param, HttpServletResponse httpServletResponse){
        wiseMapMonitorService.download(param,httpServletResponse);
    }

}
