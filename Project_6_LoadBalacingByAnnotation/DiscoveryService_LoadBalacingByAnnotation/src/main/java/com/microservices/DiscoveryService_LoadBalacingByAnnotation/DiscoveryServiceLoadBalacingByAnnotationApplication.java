package com.microservices.DiscoveryService_LoadBalacingByAnnotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServiceLoadBalacingByAnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServiceLoadBalacingByAnnotationApplication.class, args);
	}

}
