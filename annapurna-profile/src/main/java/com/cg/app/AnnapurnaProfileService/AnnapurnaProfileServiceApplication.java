package com.cg.app.AnnapurnaProfileService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AnnapurnaProfileServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnnapurnaProfileServiceApplication.class, args);
	}

}

