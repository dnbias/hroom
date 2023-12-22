package com.dnbias.hroom.server;

import com.dnbias.hroom.repository.TenantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

// @EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackageClasses = {
        com.dnbias.hroom.user.Tenant.class,
        com.dnbias.hroom.service.TenantService.class,
        com.dnbias.hroom.service.TenantServiceImpl.class,
        com.dnbias.hroom.repository.TenantRepository.class,
        com.dnbias.hroom.controller.TenantController.class
    }, scanBasePackages = "com.dnbias.hroom.controller.repository")
// @ComponentScan(basePackageClasses = com.dnbias.hroom.user.Tenant.class)
// @ComponentScan(basePackageClasses = com.dnbias.hroom.service.TenantService.class)
// @ComponentScan(basePackageClasses = com.dnbias.hroom.service.TenantServiceImpl.class)
// @ComponentScan(basePackageClasses = com.dnbias.hroom.repository.TenantRepository.class)
// @ComponentScan(basePackageClasses = com.dnbias.hroom.controller.TenantController.class)
// @EnableJpaRepositories("com.dnbias.hroom.*")
// @ComponentScan(basePackages = { "com.dnbias.hroom.*" })
// @EntityScan("com.dnbias.hroom.*")
public class TenantsServer {

    // @Autowired
    // TenantRepository tenantRepository;

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "tenants-server");
        SpringApplication.run(TenantsServer.class, args);
    }

}
