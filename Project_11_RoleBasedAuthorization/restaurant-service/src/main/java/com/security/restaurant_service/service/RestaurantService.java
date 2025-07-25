package com.security.restaurant_service.service;

import com.security.restaurant_service.dto.OrderResponseDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class RestaurantService {

    private final Map<String, OrderResponseDTO> orderMap = new HashMap<>();

    public RestaurantService() {
        // Sample hardcoded orders
        orderMap.put("35fds631", new OrderResponseDTO("35fds631", "VEG-MEALS", 1, 199, LocalDateTime.now(), "READY", 15));
        orderMap.put("9u71245h", new OrderResponseDTO("9u71245h", "HYDERABADI DUM BIRYANI", 2, 641, LocalDateTime.now(), "PREPARING", 59));
        orderMap.put("37jbd832", new OrderResponseDTO("37jbd832", "PANEER BUTTER MASALA", 1, 325, LocalDateTime.now(), "DELIVERED", 0));
    }

    public String greeting() {
        return "Welcome to Swiggy Restaurant service";
    }

    public Map<String, OrderResponseDTO> generateOrders() {
        return orderMap;
    }

    public OrderResponseDTO getOrderById(String orderId) {
        return orderMap.get(orderId); // Can return null if not found
    }
}
