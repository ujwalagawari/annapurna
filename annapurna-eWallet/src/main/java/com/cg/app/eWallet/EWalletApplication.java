package com.cg.app.eWallet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.cg.app.eWallet.entity.EWallet;
import com.cg.app.eWallet.repository.EWalletRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class EWalletApplication {

	public static void main(String[] args) {
		SpringApplication.run(EWalletApplication.class, args);
	}

	/*
	 * @Bean public CommandLineRunner produceData(EWalletRepository repository) {
	 * return (env) -> { repository.save(new EWallet(1, 5000.0));
	 * repository.save(new EWallet(2, 1000.0)); repository.save(new EWallet(3,
	 * 2000.0)); }; }
	 */
}

