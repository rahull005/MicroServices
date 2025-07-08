package com.loadbalancer.CustomerLoadBalanceByFeign.service;

import com.loadbalancer.CustomerLoadBalanceByFeign.config.FeignClient;
import com.loadbalancer.CustomerLoadBalanceByFeign.dtos.AddressResponse;
import com.loadbalancer.CustomerLoadBalanceByFeign.dtos.CustomerResponse;
import com.loadbalancer.CustomerLoadBalanceByFeign.model.Customer;
import com.loadbalancer.CustomerLoadBalanceByFeign.repository.CustomerRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo repo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    FeignClient feignClient;

    public CustomerResponse getCustById(int id) {
        Optional<Customer> customer = repo.findById(id);
        CustomerResponse customerResponse = modelMapper.map(customer, CustomerResponse.class);

        //feign client
        AddressResponse addressResponse = feignClient.addressResponse(id);
        customerResponse.setAddressResponse(addressResponse);

        System.out.println();

        return customerResponse;
    }
}
