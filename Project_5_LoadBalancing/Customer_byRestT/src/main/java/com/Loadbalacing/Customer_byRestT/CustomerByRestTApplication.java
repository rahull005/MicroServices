package com.Loadbalacing.Customer_byRestT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CustomerByRestTApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerByRestTApplication.class, args);
	}

}
