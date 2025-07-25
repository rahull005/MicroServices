package com.security.address_security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AddressSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressSecurityApplication.class, args);
	}

}
