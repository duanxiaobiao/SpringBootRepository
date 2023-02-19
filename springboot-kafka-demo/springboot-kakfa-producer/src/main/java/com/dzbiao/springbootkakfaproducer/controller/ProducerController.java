package com.dzbiao.springbootkakfaproducer.controller;

import com.alibaba.fastjson.JSONObject;
import com.dzbiao.springbootkakfaproducer.common.constant.Constant;
import com.dzbiao.springbootkakfaproducer.common.entity.SwitchLog;
import com.dzbiao.springbootkakfaproducer.service.IProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: dzbiao
 * @CreateTime: 2023/02/19 10:04
 * @Description:
 */
@RestController
@RequestMapping("/switch")
public class ProducerController {

    @Resource
    IProducerService iProducerService;

    @GetMapping("/add")
    public  String switchLogAdd() {
        return iProducerService.produceMessage();
    }

}
