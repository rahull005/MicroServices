package com.security.customer_security.service;
import com.security.customer_security.dto.AddressResponse;
import com.security.customer_security.dto.CustomerResponse;
import com.security.customer_security.model.Customer;
import com.security.customer_security.repository.CustomerRepo;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    WebClient.Builder webClient;

    @Autowired
    HttpServletRequest request;

    private final PasswordEncoder passwordEncoder;

    public CustomerResponse getCustomerById(int id) {
        Optional<Customer> customer = customerRepo.findById(id);
        CustomerResponse customerResponse = modelMapper.map(customer.get(), CustomerResponse.class);

        String token = request.getHeader("Authorization");

        AddressResponse addressResponse = webClient
                .baseUrl("http://address") // full working host:port of address service
                .build()
                .get()
                .uri("/api/address/get/{id}",id)
                .headers(headers -> headers.set("Authorization", token))
                .retrieve()
                .bodyToMono(AddressResponse.class)
                .block();
        customerResponse.setAddressResponse(addressResponse);
        return customerResponse;
    }

    public Customer addCustomer(Customer customer) {
        Customer customer1 = Customer.builder()
                .username(customer.getUsername())
                .password(passwordEncoder.encode(customer.getPassword()))
                .roles(customer.getRoles()).build();
        return customerRepo.save(customer1);
    }
}
