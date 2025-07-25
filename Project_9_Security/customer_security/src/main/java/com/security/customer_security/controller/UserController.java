package com.security.customer_security.controller;

import com.netflix.discovery.converters.Auto;
import com.security.customer_security.dto.AuthRequest;
import com.security.customer_security.jwt.JwtUtil;
import com.security.customer_security.model.Customer;
import com.security.customer_security.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    CustomerService customerService;

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/add")
    public Customer registerCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request){
        Authentication auth = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
        System.out.println("Authenticated User: " + auth.getPrincipal());

        return jwtUtil.generateToken(request.getUsername());
    }

}
