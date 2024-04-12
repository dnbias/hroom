package com.dnbias.hroom.server;

import com.dnbias.hroom.repository.FeedbackOfTenantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableAutoConfiguration
@EnableDiscoveryClient
public class FeedbacksTenantServer {

    @Autowired
    FeedbackOfTenantRepository feedbackRepository;

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "feedbacks-tenant-server");
        SpringApplication.run(FeedbacksTenantServer.class, args);
    }
}
