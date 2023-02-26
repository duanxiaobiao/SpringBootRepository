package com.dzbiao.springbootstrategy.controller;

import com.dzbiao.springbootstrategy.entity.XjSystemSearchParam;
import com.dzbiao.springbootstrategy.service.XjSystemService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: dzbiao
 * @CreateTime: 2023/02/24 22:54
 * @Description:
 */
@RestController
@RequestMapping
public class XjSystemController {

    @Resource
    private XjSystemService xjSystemService;

    @PostMapping("search")
    public String search(@RequestBody  XjSystemSearchParam param){
        return xjSystemService.search(param);
    }
}
