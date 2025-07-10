package com.apigateway.Customer_apigateway.controller;

import com.apigateway.Customer_apigateway.dto.CustomerResposnse;
import com.apigateway.Customer_apigateway.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/get/{id}")
    public CustomerResposnse getCustomerByid(@PathVariable int id){
        return customerService.getCustomerByid(id);
    }
}
