package com.security.customer_security.controller;

import com.security.customer_security.dto.CustomerResponse;
import com.security.customer_security.service.CustomerService;
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

    @GetMapping("/{id}")
    public int getId(@PathVariable int id){
        return id;
    }
}
