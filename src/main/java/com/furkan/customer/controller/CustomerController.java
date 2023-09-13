package com.furkan.customer.controller;

import com.furkan.customer.dto.CustomerDto;
import com.furkan.customer.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public CustomerDto add(@RequestBody CustomerDto customer){
        return customerService.add(customer);
    }

    @PutMapping("/{customerId}")
    public CustomerDto add(@PathVariable("customerId")Long id,@RequestBody CustomerDto customer){ return customerService.update(id, customer); }

    @GetMapping
    public List<CustomerDto> findAll(){
        return customerService.findAll();
    }

    @GetMapping("/{customerId}")
    public CustomerDto findById(@PathVariable("customerId")Long id){
        return customerService.findById(id);
    }

    @DeleteMapping("/{customerId}")
    public String deleteById(@PathVariable("customerId")Long id){
        return customerService.deleteById(id);
    }

}
