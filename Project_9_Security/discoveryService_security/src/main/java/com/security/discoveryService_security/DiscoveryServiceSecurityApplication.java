package com.security.discoveryService_security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServiceSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServiceSecurityApplication.class, args);
	}

}
