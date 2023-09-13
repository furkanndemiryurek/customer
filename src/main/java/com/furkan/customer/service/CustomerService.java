package com.furkan.customer.service;

import com.furkan.customer.dto.CustomerDto;
import com.furkan.customer.entity.Customer;
import com.furkan.customer.entity.CustomerDetail;
import com.furkan.customer.exception.CustomerNameNotNull;
import com.furkan.customer.exception.CustomerNotFoundException;
import com.furkan.customer.repo.CustomerRepository;
import lombok.val;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    CustomerRepository customerRepository;
    ModelMapper modelMapper;


    public CustomerService(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    public CustomerDto add(CustomerDto customerDto){
        if (customerDto.getFirstName().isBlank() || customerDto.getFirstName().isEmpty())
            throw new CustomerNameNotNull("Müşterinin adı boş olamaz!");
        Customer customer = modelMapper.map(customerDto, Customer.class);
        CustomerDetail customerDetail = new CustomerDetail();
        customerDetail.setAddress(customerDetail.getAddress());
        customerDetail.setPhone(customerDetail.getPhone());
        customerDetail.setMail(customerDetail.getMail());
        customer.setCustomerDetail(customerDetail);
        customerRepository.save(customer);
        return customerDto;
    }

    public CustomerDto update(Long id,CustomerDto customerDto){
        Customer customer = modelMapper.map(customerDto, Customer.class);
        customer.setId(id);
        CustomerDetail customerDetail = customer.getCustomerDetail();
        customerDetail.setAddress(customerDetail.getAddress());
        customerDetail.setPhone(customerDetail.getPhone());
        customerDetail.setMail(customerDetail.getMail());
        customer.setCustomerDetail(customerDetail);
        customerRepository.save(customer);
        return customerDto;
    }

    public List<CustomerDto> findAll(){
        List<Customer> tempCustomers = customerRepository.findAll();
        return tempCustomers.stream().map(customer ->
                modelMapper.map(customer, CustomerDto.class)).collect(Collectors.toList());
    }

    public CustomerDto findById(Long id){
        Optional<Customer> tempCustomer = customerRepository.findById(id);
        tempCustomer.orElseThrow(()->  new CustomerNameNotNull("Müşteri bulunamadı. ID : "+id));
        return modelMapper.map(tempCustomer, CustomerDto.class);
    }

    public String deleteById(Long id) {
        Optional<Customer> tempCustomer = customerRepository.findById(id);
        if (tempCustomer.isPresent()){
            customerRepository.deleteById(id);
            return "Müşteri başarıyla silindi.";
        }else
            throw new CustomerNotFoundException("Müşteri bulunamadı! ID: "+id);
    }

}
