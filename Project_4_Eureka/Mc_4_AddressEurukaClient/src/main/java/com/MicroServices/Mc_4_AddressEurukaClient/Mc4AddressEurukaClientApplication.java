package com.MicroServices.Mc_4_AddressEurukaClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Mc4AddressEurukaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Mc4AddressEurukaClientApplication.class, args);
	}

}
