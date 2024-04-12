package com.hroom.feedback.tenant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FeedbackTenantServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeedbackTenantServiceApplication.class, args);
    }

}
