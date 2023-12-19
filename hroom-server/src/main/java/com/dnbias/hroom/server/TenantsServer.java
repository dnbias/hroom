package com.dnbias.hroom.server;

import com.dnbias.hroom.repository.TenantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages="com.dnbias.hroom")
@EnableJpaRepositories("com.dnbias.hroom.*")
@ComponentScan(basePackages = { "com.dnbias.hroom.*" })
@EntityScan("com.dnbias.hroom.*")
public class TenantsServer {

    @Autowired
    TenantRepository tenantRepository;

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "tenants-server");
        SpringApplication.run(TenantsServer.class, args);
    }
}
