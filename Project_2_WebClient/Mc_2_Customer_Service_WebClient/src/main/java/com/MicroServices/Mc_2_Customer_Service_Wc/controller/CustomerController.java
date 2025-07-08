package com.MicroServices.Mc_2_Customer_Service_Wc.controller;

import com.MicroServices.Mc_2_Customer_Service_Wc.dtos.CustomerResponse;
import com.MicroServices.Mc_2_Customer_Service_Wc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/get/{id}")
    public CustomerResponse getById(@PathVariable int id){
        return service.getCustomer(id);
    }
}
