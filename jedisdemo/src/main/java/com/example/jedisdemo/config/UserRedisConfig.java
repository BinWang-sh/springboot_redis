package com.example.jedisdemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class UserRedisConfig {

    @Bean("redisUserPool")
    @ConfigurationProperties(prefix="spring.redis.user.pool")
    public JedisPoolConfig getRedisConfig() {
        return new JedisPoolConfig();
    }
}