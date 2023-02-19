package com.dzbiao.springbootkafkaconsumer.config;

import com.alibaba.fastjson.JSONObject;
import com.dzbiao.springbootkafkaconsumer.constant.Constant;
import com.dzbiao.springbootkafkaconsumer.entity.SwitchLog;
import com.dzbiao.springbootkafkaconsumer.service.ISwitchLogService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.core.env.Environment;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author: dzbiao
 * @CreateTime: 2023/02/18 10:38
 * @Description:
 */
@Component
public class SwitchLogConsumer {

    private final static String GROUP_1 = "switch-group-1" ;

    @Resource
    Environment environment;

    @Resource
    ISwitchLogService iSwitchLogService;

    /**
     *
     * @param record
     * @param ack
     */
    @KafkaListener(topics = Constant.SWITCH_LOG_TOPIC, groupId = GROUP_1)
    public void listenJihuGroup(ConsumerRecord<String, String> record, Acknowledgment ack) {
        String value = record.value();
        System.out.println("【同组消费-消费者1】:" + value);
        ack.acknowledge();
        System.out.println("端口：" + environment.getProperty("server.port"));
        SwitchLog switchLog = JSONObject.parseObject(value, SwitchLog.class);
        iSwitchLogService.updateSwitchLog(switchLog);
        System.out.println("数据库更新成功！");
    }

}
