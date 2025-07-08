package com.MicroServices.Mc_1_Customer_Service.service;

import com.MicroServices.Mc_1_Customer_Service.dto.AddressResponse;
import com.MicroServices.Mc_1_Customer_Service.dto.CustomerResponse;
import com.MicroServices.Mc_1_Customer_Service.model.Customer;
import com.MicroServices.Mc_1_Customer_Service.repository.CustomerRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo repo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ModelMapper modelMapper;

    public CustomerResponse getCustomerById(int id) {
        Optional<Customer> optionalCustomer = repo.findById(id);

        if (optionalCustomer.isEmpty()) {
            throw new RuntimeException("Customer not found with ID: " + id);
        }

        Customer customer = optionalCustomer.get();
        CustomerResponse customerResponse = new CustomerResponse();
        modelMapper.map(customer,customerResponse);
//        customerResponse.setId(customer.getId());
//        customerResponse.setUsername(customer.getUsername());
//        customerResponse.setEmail(customer.getEmail());

        // 👇 Optional: Call Address Service using RestTemplate and set addressResponse
        AddressResponse addressResponse = restTemplate.getForObject(
                "/get/" + id,
                AddressResponse.class
        );
        customerResponse.setAddressResponse(addressResponse);

        return customerResponse;
    }

    public Customer addCustomer(Customer customer) {
        return repo.save(customer);
    }


}
