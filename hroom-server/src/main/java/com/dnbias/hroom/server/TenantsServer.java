package com.dnbias.hroom.server;

import com.dnbias.hroom.repository.TenantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableAutoConfiguration
@EnableDiscoveryClient
public class TenantsServer {

    @Autowired
    TenantRepository tenantRepository;

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "tenants-server");
        SpringApplication.run(TenantsServer.class, args);
    }
}
