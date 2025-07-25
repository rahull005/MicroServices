package com.security.customer_security.service;

import com.security.customer_security.model.Customer;
import com.security.customer_security.model.CustomerImpl;
import com.security.customer_security.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerDetailsService implements UserDetailsService {

    @Autowired
    CustomerRepo customerRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return customerRepo.findByUsername(username)
                .map(CustomerImpl::new)
                .orElseThrow(()->new UsernameNotFoundException("User not found"));
    }

}
