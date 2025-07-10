package com.Loadbalacing.Customer_byRestT.service;


import com.Loadbalacing.Customer_byRestT.dto.AddressResponse;
import com.Loadbalacing.Customer_byRestT.dto.CustomerResponse;
import com.Loadbalacing.Customer_byRestT.model.Customer;
import com.Loadbalacing.Customer_byRestT.repository.CustomerRepo;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    CustomerRepo repo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    public CustomerResponse getCustomerResponse(int id){
        Optional<Customer> customer = repo.findById(id);

        log.info("Customer {}",customer);
        CustomerResponse customerResponse = modelMapper.map(customer.get(), CustomerResponse.class);


        //Choosing instance from the register
        ServiceInstance serviceInstance = loadBalancerClient.choose("Address_byRestT");
        String uri = serviceInstance.getUri().toString();
        log.info("The instance :"+uri);       //each time takes a differnt address instance in robin round manner.


        //calling the instance from chosen above
        //try running multiple instances of address services one by one and check the load balance -> robinround
        AddressResponse addressResponse = restTemplate
                .getForObject(uri+"/get/"+id, AddressResponse.class);

        customerResponse.setAddressResponse(addressResponse);
        return customerResponse;
    }
}
