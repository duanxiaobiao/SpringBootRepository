package com.dzbiao.aop.service;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author: dzbiao
 * @CreateTime: 2023/11/02 20:27
 * @Description:
 */
@Service
public class IndexService {


    public String say(Map<String, String> map) {
        System.out.println(map.get("aa"));
        System.out.println("这是say页面................");
        return "这是say页面";
    }
}
