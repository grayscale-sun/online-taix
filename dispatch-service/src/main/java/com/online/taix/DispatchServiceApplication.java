package com.online.taix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *@description : 定时任务
 *@Author : Sun
 *@date : 2021-02-15
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableScheduling
public class DispatchServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DispatchServiceApplication.class);
    }
}
