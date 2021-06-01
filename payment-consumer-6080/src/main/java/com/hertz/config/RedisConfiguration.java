package com.hertz.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.TransportMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Hertz
 * @date 2021/6/1 14:42
 */
@Configuration
public class RedisConfiguration {

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.setTransportMode(TransportMode.NIO)
                .useSingleServer()
                .setAddress("redis://127.0.0.1:6379");

        return Redisson.create(config);
    }
}
