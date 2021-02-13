package com.online.taix.config;

import com.online.taix.filter.TaixFilterFirst;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class ZuulConfig {
    @Bean
    public TaixFilterFirst taixFilterFirst(){
        return new TaixFilterFirst();
    }
}
