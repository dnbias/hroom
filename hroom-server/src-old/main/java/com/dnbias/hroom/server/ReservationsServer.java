package com.dnbias.hroom.server;

import com.dnbias.hroom.repository.ReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableAutoConfiguration
@EnableDiscoveryClient
public class ReservationsServer {

    @Autowired
    ReservationRepository reservationRepository;

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "reservation-server");
        SpringApplication.run(ReservationsServer.class, args);
    }
}
