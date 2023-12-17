package com.dnbias.hroom.server;

import com.dnbias.hroom.repository.FeedbackOfInsertionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableAutoConfiguration
@EnableDiscoveryClient
public class FeedbacksInsertionServer {

    @Autowired
    FeedbackOfInsertionRepository feedbackRepository;

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "feedbacks-insertion-server");
        SpringApplication.run(FeedbacksInsertionServer.class, args);
    }
}
