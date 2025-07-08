package com.MicroServices.Mc_4_CustomerEurukaService.service;

import com.MicroServices.Mc_4_CustomerEurukaService.OpenFeign.AddressFeign;
import com.MicroServices.Mc_4_CustomerEurukaService.dto.AddressResponse;
import com.MicroServices.Mc_4_CustomerEurukaService.dto.CustomerResponse;
import com.MicroServices.Mc_4_CustomerEurukaService.model.Customer;
import com.MicroServices.Mc_4_CustomerEurukaService.repository.CustomerRepo;
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
