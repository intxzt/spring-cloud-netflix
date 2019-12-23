package com.xzt.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudRibbonServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudRibbonServiceApplication.class, args);
    }

}
