package com.microservices.Customer_LoadBalacingByAnnotation.dtos;

import lombok.Data;

@Data
public class AddressResponse {
    private int id;
    private String village;
    private String city;
    private String postal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }
}
