package com.microservices.Customer_LoadBalacingByAnnotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CustomerLoadBalacingByAnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerLoadBalacingByAnnotationApplication.class, args);
	}

}
