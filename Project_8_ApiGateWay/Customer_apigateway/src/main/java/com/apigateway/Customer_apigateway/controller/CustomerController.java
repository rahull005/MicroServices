package com.apigateway.Customer_apigateway.controller;

import com.apigateway.Customer_apigateway.dto.CustomerResponse;
import com.apigateway.Customer_apigateway.model.Customer;
import com.apigateway.Customer_apigateway.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    CustomerService service;

    @GetMapping("/get/{id}")
    public Optional<CustomerResponse> getCustomerById(@PathVariable int id){
        return Optional.ofNullable(service.getCustomerById(id));
    }
}
