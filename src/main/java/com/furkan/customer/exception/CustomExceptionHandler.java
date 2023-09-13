package com.furkan.customer.exception;

import com.furkan.customer.entity.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<?> customerNotFound(CustomerNotFoundException customerNotFoundException){
        ErrorResponse errorResponse =
                new ErrorResponse(customerNotFoundException.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomerNameNotNull.class)
    public ResponseEntity<?> customerNameNotNull(CustomerNameNotNull customerNameNotNull){
        ErrorResponse errorResponse =
                new ErrorResponse(customerNameNotNull.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
