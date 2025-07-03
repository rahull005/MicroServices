package com.MicroServices.Mc_2_Customer_Service_Wc.dtos;

import lombok.Data;

@Data
public class AddressResponse {
    private int id;
    private String village;
    private String city;
    private String postal;
}