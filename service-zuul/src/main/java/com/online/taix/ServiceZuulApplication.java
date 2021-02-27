package com.online.taix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient(autoRegister = false)
@EnableZuulProxy
@ServletComponentScan
public class ServiceZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceZuulApplication.class);
    }
}
