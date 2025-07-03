package com.MicroServices.Mc_3_Customer_Service_FeignClient.dto;

import lombok.Data;

@Data
public class AddressResponse {
    private int id;
    private String village;
    private String city;
    private String postal;
}
