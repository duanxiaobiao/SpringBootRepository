package com.dzbiao.springbootwebsocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: dzbiao
 * @CreateTime: 2023/11/20 23:07
 * @Description:
 */
@Controller
public class ModelViewController {

    /**
     * 主页
     * @return
     */
    @RequestMapping("/index")
    public String modelView(){
        return "index";
    }
}
