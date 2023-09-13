package com.furkan.customer.dto;

import lombok.Data;

@Data
public class CustomerDetailDto {
    private Long id;
    private String address;
    private String phone;
    private String mail;
}
