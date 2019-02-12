package com.capgemini.annapurnaconfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 
 * @author ugawari
 *
 */
@EnableConfigServer
@SpringBootApplication
public class AnnapurnaConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnnapurnaConfigApplication.class, args);
	}

}

