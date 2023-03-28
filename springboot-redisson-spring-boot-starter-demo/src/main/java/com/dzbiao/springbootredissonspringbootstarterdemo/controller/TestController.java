package com.dzbiao.springbootredissonspringbootstarterdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dzbiao.springbootredissonspringbootstarterdemo.common.annotation.LogAnnotation;
import com.dzbiao.springbootredissonspringbootstarterdemo.common.annotation.RedissonLockAnnotation;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : JCccc
 * @CreateTime : 2020/5/13
 * @Description :
 **/
@RestController
public class TestController {

    @Autowired
    private RedissonClient redissonClient;

    @PostMapping(value = "testLock", consumes = "application/json")
    @RedissonLockAnnotation(lockRedisKey = "productName,platFormName")
    public String testLock(@RequestBody JSONObject params) throws InterruptedException {
        /**
         * 分布式锁key=params.getString("productName")+params.getString("platFormName");
         * productName 产品名称  platFormName 平台名称 如果都一致,那么分布式锁的key就会一直,那么就能避免并发问题
         */
        //TODO 业务处理

        System.out.println("接收到的参数："+params.toString());
        System.out.println("执行相关业务...");
        System.out.println("执行相关业务.....");

        System.out.println("执行相关业务......");

        return "success";
    }


    @PostMapping(value = "testLock1")
    @LogAnnotation
    public String testLock1(@RequestBody JSONObject params) throws InterruptedException {
        //TODO 业务处理

        System.out.println("接收到的参数："+params.toString());
        System.out.println("执行相关业务...");
        System.out.println("执行相关业务.....");

        System.out.println("执行相关业务......");

        return "success";
    }
}
