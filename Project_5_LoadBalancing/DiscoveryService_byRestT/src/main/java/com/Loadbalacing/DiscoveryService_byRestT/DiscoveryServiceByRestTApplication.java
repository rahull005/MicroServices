package com.Loadbalacing.DiscoveryService_byRestT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServiceByRestTApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServiceByRestTApplication.class, args);
	}

}
