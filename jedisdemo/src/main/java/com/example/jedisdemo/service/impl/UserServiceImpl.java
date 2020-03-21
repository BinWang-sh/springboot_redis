package com.example.jedisdemo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.jedisdemo.pojo.User;
import com.example.jedisdemo.redis.RedisKey;
import com.example.jedisdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService{
    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    @Qualifier("userRedisTemplate")
    protected RedisTemplate<String, Object> userRedisTemplate;

    @Override
    public User getUser(String usrId) {
        String tempVal = (String)userRedisTemplate.opsForHash().values(RedisKey.REDIS_USER_ACTIVE_KEY+usrId).get(0);
        if ((tempVal==null)||(tempVal.length()==0)) {
            return null;
        }

        try {
            return JSON.parseObject(tempVal, User.class);
        } catch (Exception e) {
            logger.warn(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public void setUser(User user) {
        String key  = RedisKey.REDIS_USER_ACTIVE_KEY+user.getUID();
        String data = JSONObject.toJSONString(user);
        String hashKey = user.getUID();
        logger.info("User write to redis,key={},hashKey={},content={}",key, hashKey, data);
        userRedisTemplate.opsForHash().put(key, hashKey, data);
    }
}
