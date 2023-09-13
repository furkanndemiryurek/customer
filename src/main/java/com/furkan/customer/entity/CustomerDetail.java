package com.furkan.customer.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "customer_details")
@Data
public class CustomerDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String phone;
    private String mail;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "customerDetail")
    Customer customer;

}
