package com.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@EntityScan(basePackages = "com.model")
@EnableJpaRepositories(basePackages = "com.repository")
@SpringBootApplication(scanBasePackages = { "com.controller", "com.service","com.inicio"  })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@LoadBalanced
	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}	

}
