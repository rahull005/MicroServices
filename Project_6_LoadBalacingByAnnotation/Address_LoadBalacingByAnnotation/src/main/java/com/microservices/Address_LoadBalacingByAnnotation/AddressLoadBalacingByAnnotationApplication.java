package com.microservices.Address_LoadBalacingByAnnotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AddressLoadBalacingByAnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressLoadBalacingByAnnotationApplication.class, args);
	}

}
