package com.security.restaurant_service.controller;

import com.security.restaurant_service.dto.OrderResponseDTO;
import com.security.restaurant_service.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService service;

    @GetMapping
    public String greetingMessage() {
        return service.greeting();
    }

    @GetMapping("/all")
    public Map<String, OrderResponseDTO> getOrder() {
        return service.generateOrders();
    }

    @GetMapping("/getOrderById/{id}")
    public OrderResponseDTO getOrderByid(@PathVariable String id){
        return service.getOrderById(id);
    }

}
