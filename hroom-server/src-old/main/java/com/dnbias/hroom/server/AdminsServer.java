package com.dnbias.hroom.server;

import com.dnbias.hroom.repository.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableAutoConfiguration
@EnableDiscoveryClient
public class AdminsServer {

    @Autowired
    AdminRepository adminRepository;

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "admins-server");
        SpringApplication.run(AdminsServer.class, args);
    }
}
