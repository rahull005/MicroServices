package com.apigateway.Customer_apigateway.config;

import com.apigateway.Customer_apigateway.dto.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "address" ,path = "/api/address")
public interface OpenFeign {
    @GetMapping("/get/{id}")
    public AddressResponse address(@PathVariable int id);
}
