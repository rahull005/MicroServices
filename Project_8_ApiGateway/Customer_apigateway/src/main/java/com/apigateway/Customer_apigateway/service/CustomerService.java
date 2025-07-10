package com.apigateway.Customer_apigateway.service;

import com.apigateway.Customer_apigateway.config.OpenFeign;
import com.apigateway.Customer_apigateway.dto.AddressResponse;
import com.apigateway.Customer_apigateway.dto.CustomerResposnse;
import com.apigateway.Customer_apigateway.model.Customer;
import com.apigateway.Customer_apigateway.repository.CustomerRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    OpenFeign openFeign;

    @Autowired
    WebClient.Builder webClient;

    public CustomerResposnse getCustomerByid(int id) {
        Optional<Customer> customer = customerRepo.findById(id);
        CustomerResposnse customerResposnse = modelMapper.map(
                customer.get(), CustomerResposnse.class
        );


//        AddressResponse addressResponse = openFeign.address(id);


        AddressResponse addressResponse = webClient
                .baseUrl("http://ADDRESS")  // Eureka will resolve this and select particular instance
                .build()
                .get()
                .uri("/api/address/get/{id}", id)
                .retrieve()
                .bodyToMono(AddressResponse.class)
                .block();

        customerResposnse.setAddressResponse(addressResponse);
        return customerResposnse;
    }
}
