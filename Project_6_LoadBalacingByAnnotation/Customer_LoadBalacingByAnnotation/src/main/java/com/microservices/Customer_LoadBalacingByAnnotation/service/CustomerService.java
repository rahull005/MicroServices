package com.microservices.Customer_LoadBalacingByAnnotation.service;

import com.microservices.Customer_LoadBalacingByAnnotation.dtos.AddressResponse;
import com.microservices.Customer_LoadBalacingByAnnotation.dtos.CustomerResponse;
import com.microservices.Customer_LoadBalacingByAnnotation.model.Customer;
import com.microservices.Customer_LoadBalacingByAnnotation.repository.CustomerRepo;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.Optional;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private RestTemplate restTemplate;


//    @Autowired
//    LoadBalancerClient loadBalancerClient;   //-> Incase we use the service instance method

    public Customer addcustomer(Customer customer){
        return customerRepo.save(customer);
    }

    public CustomerResponse getCustomerByIdwAddress(int id) {
        Optional<Customer> customer = customerRepo.findById(id);
        CustomerResponse customerResponse = modelMapper.map(customer.get(), CustomerResponse.class);

//        ServiceInstance serviceInstance = loadBalancerClient.choose("Address_LoadBalacingByAnnotation");
//        String uri = serviceInstance.getUri().toString();
//        log.info("The instance :"+uri);       each time takes a differnt address instance in robin round manner.


        //calling the instance from chosen above
        //try running multiple instances of address services one by one and check the load balance -> robinround
        AddressResponse addressResponse = restTemplate.getForObject(
                "http://ADDRESS/get/" + id,
                AddressResponse.class
        );




        customerResponse.setAddressResponse(addressResponse);
        log.info(String.valueOf(customerResponse));
        return customerResponse;

    }

    public Optional<Customer> getCustomer(int id) {
        return customerRepo.findById(id);
    }
}
