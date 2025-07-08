package com.MicroServices.Mc_4_CustomerEurukaService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Mc4CustomerEurukaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Mc4CustomerEurukaServiceApplication.class, args);
	}

}
