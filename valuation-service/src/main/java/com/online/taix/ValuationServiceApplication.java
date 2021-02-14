package com.online.taix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableDiscoveryClient(autoRegister = false)
@EnableAsync
public class ValuationServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ValuationServiceApplication.class);
    }
}
