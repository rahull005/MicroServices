package com.MicroServices.Mc_4_CustomerEurukaService.dto;

import lombok.Data;

@Data
public class AddressResponse {
    private int id;
    private String village;
    private String city;
    private String postal;
}
