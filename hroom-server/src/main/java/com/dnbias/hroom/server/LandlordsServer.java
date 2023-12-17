package com.dnbias.hroom.server;

import com.dnbias.hroom.repository.LandlordRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableAutoConfiguration
@EnableDiscoveryClient
public class LandlordsServer {

    @Autowired
    LandlordRepository landlordRepository;

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "landlords-server");
        SpringApplication.run(LandlordsServer.class, args);
    }
}
