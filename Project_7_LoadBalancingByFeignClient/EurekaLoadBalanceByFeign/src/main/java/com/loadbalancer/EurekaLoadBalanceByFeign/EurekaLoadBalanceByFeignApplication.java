package com.loadbalancer.EurekaLoadBalanceByFeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaLoadBalanceByFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaLoadBalanceByFeignApplication.class, args);
	}

}
