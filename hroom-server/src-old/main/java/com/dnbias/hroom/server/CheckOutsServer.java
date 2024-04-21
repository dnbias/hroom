package com.dnbias.hroom.server;

import com.dnbias.hroom.repository.CheckOutRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableAutoConfiguration
@EnableDiscoveryClient
public class CheckOutsServer {

    @Autowired
    CheckOutRepository checkOutRepository;

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "checkouts-server");
        SpringApplication.run(CheckOutsServer.class, args);
    }
}
