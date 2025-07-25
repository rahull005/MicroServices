package com.security.swiggy_app.controller;

import com.security.swiggy_app.entities.OrderResponseDto;
import com.security.swiggy_app.service.SwiggyService;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/swiggy")
public class SwiggyController {

    @Autowired
    SwiggyService swiggyService;

    @GetMapping("/get/{id}")
    public OrderResponseDto getById(@PathVariable String id){
        return swiggyService.getorderResponse(id);
    }

    @GetMapping("/admin/data")
    public ResponseEntity<String> getAdminData() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Authenticated user: " + auth.getName());
        System.out.println("Authorities: " + auth.getAuthorities());
        return ResponseEntity.ok("Admin data only");
    }

    @GetMapping("/user/data")
    public ResponseEntity<String> getUserData() {
        return ResponseEntity.ok("User data accessible by USER or ADMIN");
    }

    @GetMapping("/admin/orders")
    public ResponseEntity<String> getAdminOrders(@RequestHeader("X-User") String username,
                                                 @RequestHeader("X-Roles") String rolesHeader) {
        List<String> roles = Arrays.stream(rolesHeader.split(","))
                .map(String::trim)
                .toList();

        if (roles.contains("ROLE_ADMIN")) {
            return ResponseEntity.ok("Admin Orders for: " + username);
        }

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access Denied");
    }

}
