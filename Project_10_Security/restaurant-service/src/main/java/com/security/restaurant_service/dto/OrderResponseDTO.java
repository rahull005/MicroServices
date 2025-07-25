package com.security.restaurant_service.dto;
import java.time.LocalDateTime;
public class OrderResponseDTO {
    private String orderId;
    private String name;
    private int qty;
    private double price;
    private LocalDateTime orderDate;
    private String status;
    private int estimateDeliveryWindow;

    public OrderResponseDTO(String orderId, String name, int qty, double price, LocalDateTime orderDate, String status, int estimateDeliveryWindow) {
        this.orderId = orderId;
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.orderDate = orderDate;
        this.status = status;
        this.estimateDeliveryWindow = estimateDeliveryWindow;
    }

    public OrderResponseDTO() {

    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getEstimateDeliveryWindow() {
        return estimateDeliveryWindow;
    }

    public void setEstimateDeliveryWindow(int estimateDeliveryWindow) {
        this.estimateDeliveryWindow = estimateDeliveryWindow;
    }
}

