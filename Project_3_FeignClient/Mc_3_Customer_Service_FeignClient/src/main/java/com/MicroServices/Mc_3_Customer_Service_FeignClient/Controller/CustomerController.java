package com.MicroServices.Mc_3_Customer_Service_FeignClient.Controller;

import com.MicroServices.Mc_3_Customer_Service_FeignClient.dto.CustomerResponse;
import com.MicroServices.Mc_3_Customer_Service_FeignClient.service.CustomerService;
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
