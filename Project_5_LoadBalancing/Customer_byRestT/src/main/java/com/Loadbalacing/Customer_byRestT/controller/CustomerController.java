package com.Loadbalacing.Customer_byRestT.controller;


import com.Loadbalacing.Customer_byRestT.dto.CustomerResponse;
import com.Loadbalacing.Customer_byRestT.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    CustomerService service;

    @GetMapping("/get/{id}")
    public CustomerResponse getCustomerResponseById(@PathVariable int id){
        return service.getCustomerResponse(id);
    }
}
