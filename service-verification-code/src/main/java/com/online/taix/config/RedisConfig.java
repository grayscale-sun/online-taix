package com.online.taix.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig{

    @Bean(name = "redisConfiguration")
    public RedisStandaloneConfiguration redisConfiguration(){
        final RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName("127.0.0.1");
        redisStandaloneConfiguration.setPort(6379);
        return redisStandaloneConfiguration;
    }

    @Bean(name = "redisConnectionFactory")
    @DependsOn(value = "redisConfiguration")
    public JedisConnectionFactory redisConnectionFactory(RedisStandaloneConfiguration redisConfiguration){
        final JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisConfiguration);
        return jedisConnectionFactory;
    }

    @Bean
    @DependsOn(value = "redisConnectionFactory")
    public RedisTemplate redisTemplate(JedisConnectionFactory redisConnectionFactory){
        final RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }


}
