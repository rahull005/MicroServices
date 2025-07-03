package com.MicroServices.Mc_3_Customer_Service_FeignClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

public class Mc3CustomerServiceFeignClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Mc3CustomerServiceFeignClientApplication.class, args);
	}

}
