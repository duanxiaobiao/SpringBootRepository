package com.dzbiao.springbootredission.common.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: dzbiao
 * @CreateTime: 2023/03/26 20:46
 * @Description:
 */
@Configuration
public class RedissonConfig {


    /**
     * 所有对Redisson的使用都是通过RedissonClient对象
     * @return
     */
    @Bean(destroyMethod = "shutdown")
    public RedissonClient redissonClient(){
        // 创建配置 指定redis地址及节点信息
        Config config = new Config();
        config.useSingleServer().setAddress("redis://172.16.10.128:6379").setPassword("root");

        // 根据config创建出RedissonClient实例
        RedissonClient redissonClient = Redisson.create(config);
        return redissonClient;
    }

}
