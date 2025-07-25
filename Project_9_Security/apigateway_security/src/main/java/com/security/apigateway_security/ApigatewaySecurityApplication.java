package com.security.apigateway_security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApigatewaySecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApigatewaySecurityApplication.class, args);
	}

}
