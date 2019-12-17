package com.xzt.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudAdminClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudAdminClientApplication.class, args);
    }

}
