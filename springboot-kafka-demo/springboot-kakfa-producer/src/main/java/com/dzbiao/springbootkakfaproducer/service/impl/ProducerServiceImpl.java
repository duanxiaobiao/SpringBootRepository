package com.dzbiao.springbootkakfaproducer.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dzbiao.springbootkakfaproducer.common.constant.Constant;
import com.dzbiao.springbootkakfaproducer.common.entity.SwitchLog;
import com.dzbiao.springbootkakfaproducer.service.IProducerService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author: dzbiao
 * @CreateTime: 2023/02/19 10:12
 * @Description:
 */
@Service
public class ProducerServiceImpl implements IProducerService {


    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;


    /**
     * 生产消息
     * @return
     */
    @Override
    public String produceMessage() {
        String indexDate = LocalDateTime.now().format(Constant.DATE_TIME_FORMAT);
        SwitchLog switchLog = SwitchLog.builder().indexName(Constant.INDEX_TEMPLATE).indexDate(indexDate)
                .indexNameDate(Constant.INDEX_TEMPLATE + "_" + indexDate).build();
        String message = JSONObject.toJSONString(switchLog);
        kafkaTemplate.send(Constant.SWITCH_LOG_TOPIC, message);
        System.out.println("【成功添加】" + message);
        return "OK";
    }
}
