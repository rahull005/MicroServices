package com.microservices.Customer_LoadBalacingByAnnotation.controller;

import com.microservices.Customer_LoadBalacingByAnnotation.dtos.CustomerResponse;
import com.microservices.Customer_LoadBalacingByAnnotation.model.Customer;
import com.microservices.Customer_LoadBalacingByAnnotation.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerService service;

    @PostMapping("/add")
    public Customer addCustomer(@RequestBody Customer customer){
        return service.addcustomer(customer);
    }

    @GetMapping("/get/{id}")
    public CustomerResponse getCustomerByIdwAddress(@PathVariable int id){
        return service.getCustomerByIdwAddress(id);
    }

    @GetMapping("/getCustomer/{id}")
    public Optional<Customer> getCustomer(@PathVariable int id){
        return service.getCustomer(id);
    }
}
