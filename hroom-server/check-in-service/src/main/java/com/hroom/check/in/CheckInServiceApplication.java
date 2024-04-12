package com.hroom.check.in;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CheckInServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CheckInServiceApplication.class, args);
    }

}
