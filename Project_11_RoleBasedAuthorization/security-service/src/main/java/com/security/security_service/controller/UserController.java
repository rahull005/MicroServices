package com.security.security_service.controller;

import com.security.security_service.entities.AuthRequest;
import com.security.security_service.entities.User;
import com.security.security_service.entities.UserImp;
import com.security.security_service.jwt.JwtUtils;
import com.security.security_service.service.UserDetailsService;
import com.security.security_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    JwtUtils jwtservice;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PostMapping("/token")
    public String generateToken(@RequestBody AuthRequest request){
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
        UserImp user = (UserImp) userDetailsService.loadUserByUsername(request.getUsername());
        return jwtservice.generateToken(user);
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token){
        jwtservice.validateToken(token);
        return "Token is valid";
    }
}
