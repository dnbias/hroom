package com.hroom.feedbackinsertion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FeedbackInsertionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeedbackInsertionServiceApplication.class, args);
    }

}
