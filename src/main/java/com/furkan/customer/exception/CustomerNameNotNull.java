package com.furkan.customer.exception;

public class CustomerNameNotNull extends RuntimeException{
    public CustomerNameNotNull(String message){
        super(message);
    }
}
