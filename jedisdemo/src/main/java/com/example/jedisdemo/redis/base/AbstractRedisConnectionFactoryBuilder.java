package com.example.jedisdemo.redis.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPoolConfig;

@Slf4j
public class AbstractRedisConnectionFactoryBuilder <T extends RedisConnectionFactory> {

    private JedisPoolConfig jedisPoolConfig;

    /**
     * @return
     */
    public T getConnectionFactory() {
        log.info("Jedis Config: {}", jedisPoolConfig.toString());
        final JedisConnectionFactory factory =  new JedisConnectionFactory();
        factory.setPoolConfig(getJedisPoolConfig());
        return (T)factory;
    }

    protected JedisPoolConfig getJedisPoolConfig() {
        return jedisPoolConfig;
    }

    public void setJedisPoolConfig(JedisPoolConfig jedisPoolConfig) {
        this.jedisPoolConfig = jedisPoolConfig;
    }
}