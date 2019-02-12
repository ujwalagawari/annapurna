package com.capgemini.annapurnaeureka;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 
 * @author ugawari
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class AnnapurnaEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnnapurnaEurekaApplication.class, args);
	}

}

