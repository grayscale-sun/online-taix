package com.online.taix.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisUtils {

    @Autowired
    RedisTemplate redisTemplate;

    public void signInRedis(String key, Object value, long outtime, TimeUnit timeUnit){
        //set key
        final ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key,value,outtime,timeUnit);
    }

    public Object getValueFromRedis(String key){
        //get key
        final ValueOperations valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(key);
    }

}
