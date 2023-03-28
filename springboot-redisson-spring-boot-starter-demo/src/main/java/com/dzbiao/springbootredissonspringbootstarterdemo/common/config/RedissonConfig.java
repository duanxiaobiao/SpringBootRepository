package com.dzbiao.springbootredissonspringbootstarterdemo.common.config;

import com.dzbiao.springbootredissonspringbootstarterdemo.common.util.RedissonLockUtils;
import com.dzbiao.springbootredissonspringbootstarterdemo.service.impl.RedissonDistributeLocker;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: dzbiao
 * @CreateTime: 2023/03/28 21:30
 * @Description:
 */

@Configuration
public class RedissonConfig {


    /**
     * Redisson客户端注册
     * 单机模式
     */
    @Bean(destroyMethod = "shutdown")
    public RedissonClient createRedissonClient() {
       Config config = new Config();
        SingleServerConfig singleServerConfig = config.useSingleServer();
        singleServerConfig.setAddress("redis://172.16.10.128:6379");
        singleServerConfig.setPassword("root");
        singleServerConfig.setTimeout(3000);
        return Redisson.create(config);
    }



    @Bean
    public RedissonDistributeLocker redissonLocker(RedissonClient redissonClient) {
        RedissonDistributeLocker locker = new RedissonDistributeLocker(redissonClient);
        RedissonLockUtils.setLocker(locker);
        return locker;
    }
}
