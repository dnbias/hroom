package com.dnbias.hroom;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.dnbias.hroom.*")
@ComponentScan(basePackages = { "com.dnbias.hroom.*" })
@EntityScan("com.dnbias.hroom.*")
public class HroomApplication {

	public static void main(String[] args) {
		SpringApplication.run(HroomApplication.class, args);

	}
}
