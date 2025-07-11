package com.apigateway.Customer_apigateway.service;

import com.apigateway.Customer_apigateway.dto.AddressResponse;
import com.apigateway.Customer_apigateway.dto.CustomerResponse;
import com.apigateway.Customer_apigateway.model.Customer;
import com.apigateway.Customer_apigateway.repository.CustomerRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    WebClient.Builder webClient;

    public CustomerResponse getCustomerById(int id) {
        Optional<Customer> customer = customerRepo.findById(id);
        CustomerResponse customerResponse = modelMapper.map(customer.get(), CustomerResponse.class);

        AddressResponse addressResponse = webClient
                .baseUrl("http://address") // full working host:port of address service
                .build()
                .get()
                .uri("/api/address/get/{id}",id)
                .retrieve()
                .bodyToMono(AddressResponse.class)
                .block();
        customerResponse.setAddressResponse(addressResponse);
        return customerResponse;
    }
}
