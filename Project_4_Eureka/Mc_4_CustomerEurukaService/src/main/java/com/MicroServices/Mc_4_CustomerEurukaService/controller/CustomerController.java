package com.MicroServices.Mc_4_CustomerEurukaService.controller;

import com.MicroServices.Mc_4_CustomerEurukaService.dto.CustomerResponse;
import com.MicroServices.Mc_4_CustomerEurukaService.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
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
