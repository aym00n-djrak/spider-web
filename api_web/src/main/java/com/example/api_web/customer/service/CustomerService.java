package com.example.api_web.customer.service;

import com.example.api_web.customer.dto.CustomerDTO;
import com.example.api_web.customer.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    public List<CustomerDTO> getAllCustomers();

    public CustomerDTO getCustomerById(UUID id);

    public CustomerDTO createCustomer(CustomerDTO customerDTO);

    public CustomerDTO updateCustomer(CustomerDTO customerDTO);

    public void deleteCustomer(UUID id);
}
