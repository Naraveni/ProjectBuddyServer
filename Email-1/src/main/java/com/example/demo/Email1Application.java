package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EntityScan("com.example.model") // Scan for entities in this package
@EnableJpaRepositories("com.example.repository") // S
@ComponentScan(basePackages = {"com.example"})
public class Email1Application {

	public static void main(String[] args) {
		SpringApplication.run(Email1Application.class, args);
	}

}
