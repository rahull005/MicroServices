package com.security.swiggy_app.controller;

import com.security.swiggy_app.entities.OrderResponseDto;
import com.security.swiggy_app.service.SwiggyService;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/swiggy")
public class SwiggyController {

    @Autowired
    SwiggyService swiggyService;

    @GetMapping("/get/{id}")
    public OrderResponseDto getById(@PathVariable String id){
        return swiggyService.getorderResponse(id);
    }
}
