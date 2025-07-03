package com.MicroServices.Mc_2_Customer_Service_Wc.service;

import com.MicroServices.Mc_2_Customer_Service_Wc.dtos.AddressResponse;
import com.MicroServices.Mc_2_Customer_Service_Wc.dtos.CustomerResponse;
import com.MicroServices.Mc_2_Customer_Service_Wc.model.Customer;
import com.MicroServices.Mc_2_Customer_Service_Wc.repository.CustomerRepo;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;
import java.util.logging.Logger;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private CustomerRepo repo;

    @Autowired
    WebClient webClient;

    org.slf4j.Logger logger=  LoggerFactory.getLogger(Customer.class);

    public CustomerResponse getCustomer(int id){

        Optional<Customer> Optionalcustomer = repo.findById(id);
        Customer customer = Optionalcustomer.get();

        CustomerResponse customerResponse = new CustomerResponse();
        modelMapper.map(customer,customerResponse);

        //address
//        WebClient.Builder builder = webClient.baseUrl(baseUrl);
        AddressResponse addressResponse = webClient
                .get().uri("get/"+id)
                .retrieve()
                .bodyToMono(AddressResponse.class)
                .block();
        customerResponse.setAddressResponse(addressResponse);
        return customerResponse;
    }
}
