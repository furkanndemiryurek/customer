package com.furkan.customer.dto;

import lombok.Data;

@Data
public class CustomerDto {
    private Long id;
    private String firstName;
    private String lastName;
    private CustomerDetailDto customerDetail;
}
