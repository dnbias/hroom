package com.hroom.landlord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LandlordServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LandlordServiceApplication.class, args);
    }

}
