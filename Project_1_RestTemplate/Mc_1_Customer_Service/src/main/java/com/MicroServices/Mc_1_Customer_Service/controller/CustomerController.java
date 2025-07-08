package com.MicroServices.Mc_1_Customer_Service.controller;

import com.MicroServices.Mc_1_Customer_Service.dto.CustomerResponse;
import com.MicroServices.Mc_1_Customer_Service.model.Customer;
import com.MicroServices.Mc_1_Customer_Service.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @Autowired
    CustomerService service;

    @PostMapping("/add")
    public Customer addCustomer(@RequestBody Customer customer){
        return service.addCustomer(customer);
    }

    @GetMapping("/get/{id}")
    public CustomerResponse getCustomerbyId(@PathVariable int id){
        return service.getCustomerById(id);
    }
}
