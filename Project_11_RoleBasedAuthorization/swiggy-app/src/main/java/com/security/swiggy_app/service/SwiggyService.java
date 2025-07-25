package com.security.swiggy_app.service;

import com.security.swiggy_app.entities.OrderResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class SwiggyService {

    @Autowired
    WebClient.Builder webclient;

    public OrderResponseDto getorderResponse(String id){
        OrderResponseDto orderResponseDto = webclient
                .baseUrl("http://RESTAURANT") // full working host:port of address service
                .build()
                .get()
                .uri("/api/restaurant/getOrderById/{id}",id)
                .retrieve()
                .bodyToMono(OrderResponseDto.class)
                .block();
        return orderResponseDto;
    }
}
