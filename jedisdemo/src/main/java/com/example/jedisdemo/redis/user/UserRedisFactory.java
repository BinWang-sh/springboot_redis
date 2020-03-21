package com.example.jedisdemo.redis.user;

import com.example.jedisdemo.redis.base.AbstractRedisFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

public class UserRedisFactory extends AbstractRedisFactory {

    @Override
    @Bean("userRedisTemplate")
    public <V> RedisTemplate<String, V> getRedisTemplate() {
        return super.getRedisTemplate();
    }


    @Override
    @Autowired
    @Qualifier("userConnectionFactory")
    public void setConnectionFactory(RedisConnectionFactory connectionFactory) {
        super.setConnectionFactory(connectionFactory);
    }
}
