package com.dnbias.hroom.server;

import com.dnbias.hroom.repository.InsertionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableAutoConfiguration
@EnableDiscoveryClient
public class InsertionsServer {

    @Autowired
    InsertionRepository insertionRepository;

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "insertions-server");
        SpringApplication.run(InsertionsServer.class, args);
    }
}
