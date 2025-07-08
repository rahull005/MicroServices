package com.loadbalancer.CustomerLoadBalanceByFeign.controller;

import com.loadbalancer.CustomerLoadBalanceByFeign.dtos.CustomerResponse;
import com.loadbalancer.CustomerLoadBalanceByFeign.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/get/{id}")
    public CustomerResponse customerResponsegetById(@PathVariable int id){
        return customerService.getCustById(id);
    }
}
