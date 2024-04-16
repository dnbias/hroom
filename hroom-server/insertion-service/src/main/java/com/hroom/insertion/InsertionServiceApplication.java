package com.hroom.insertion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class InsertionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InsertionServiceApplication.class, args);
    }

}
