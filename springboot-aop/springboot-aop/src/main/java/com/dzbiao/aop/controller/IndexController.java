package com.dzbiao.aop.controller;

import com.dzbiao.aop.service.IndexService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author: dzbiao
 * @CreateTime: 2023/11/02 20:23
 * @Description:
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @Resource
    private IndexService indexService;

    @GetMapping("/")
    public String index(){
        System.out.println("这是index页面................");
        return "OK";
    }


    @PostMapping("/say")
    public String say(@RequestBody Map<String, String> map) {
        return indexService.say(map);
    }

}
