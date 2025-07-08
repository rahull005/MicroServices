package com.MicroServices.Mc_3_Customer_Service_FeignClient.service;

import com.MicroServices.Mc_3_Customer_Service_FeignClient.dto.AddressResponse;
import com.MicroServices.Mc_3_Customer_Service_FeignClient.dto.CustomerResponse;
import com.MicroServices.Mc_3_Customer_Service_FeignClient.feignCliet.AddressFeign;
import com.MicroServices.Mc_3_Customer_Service_FeignClient.model.Customer;
import com.MicroServices.Mc_3_Customer_Service_FeignClient.repository.CustomerRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo repo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AddressFeign addressFeign;

    public CustomerResponse getCustomerResponse(int id){
        Optional<Customer> optionalCustomer = repo.findById(id);
        Customer customer = optionalCustomer.get();
        CustomerResponse customerResponse = new CustomerResponse();
        modelMapper.map(customer,customerResponse);

        AddressResponse addressResponse = addressFeign.addressResponse(id);
        customerResponse.setAddressResponse(addressResponse);
        return customerResponse;
    }
}
