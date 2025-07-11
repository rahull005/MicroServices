package com.MicroServices.Mc_1_Customer_Service.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.rootUri("http://localhost:8081").build();
    }
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
