package com.example.jedisdemo.redis.builder;

import com.example.jedisdemo.redis.base.AbstractRedisConnectionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class UserRedisConnectionFactoryBuilder extends AbstractRedisConnectionFactoryBuilder<JedisConnectionFactory> {

    @Override
    @Autowired
    @Qualifier("redisUserPool")
    public void setJedisPoolConfig(JedisPoolConfig jedisPoolConfig) {
        super.setJedisPoolConfig(jedisPoolConfig);
    }

    @Override
    @Bean("userConnectFactory")
    @ConfigurationProperties(prefix="spring.redis.user")
    public JedisConnectionFactory getConnectionFactory() {
        return super.getConnectionFactory();
    }
}