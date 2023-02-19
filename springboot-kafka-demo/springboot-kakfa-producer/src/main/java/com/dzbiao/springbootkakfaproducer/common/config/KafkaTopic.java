package com.dzbiao.springbootkakfaproducer.common.config;

import com.dzbiao.springbootkakfaproducer.common.constant.Constant;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author :dzbiao
 * 使用代码创建的topic
 * 三个参数意思：topic的名称；分区数量，新主题的复制因子；如果指定了副本分配，则为-1。
 */
@Configuration
public class KafkaTopic {

     @Bean
    public NewTopic batchTopic() {
        return new NewTopic(Constant.SWITCH_LOG_TOPIC, 8, (short) 1);
    }
}