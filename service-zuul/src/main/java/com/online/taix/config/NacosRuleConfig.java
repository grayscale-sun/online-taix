package com.online.taix.config;

import com.netflix.loadbalancer.IRule;
import com.online.taix.rule.NacosRule;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RibbonClient(value = "service-zuul",configuration = NacosRule.class)
public class NacosRuleConfig {
    @Bean
    public IRule LoadBalancesRule(){
        return new NacosRule();
    }
}
