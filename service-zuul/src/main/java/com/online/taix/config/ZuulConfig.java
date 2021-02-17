package com.online.taix.config;

import com.netflix.loadbalancer.RoundRobinRule;
import com.online.taix.filter.TaixFilterFirst;
import com.online.taix.utils.RibbonUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class ZuulConfig {
    @Bean
    public TaixFilterFirst taixFilterFirst(){
        return new TaixFilterFirst();
    }
}
