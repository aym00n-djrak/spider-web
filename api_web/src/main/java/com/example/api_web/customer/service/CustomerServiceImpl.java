package com.example.api_web.customer.service;

import com.example.api_web.customer.dao.CustomerRepository;
import com.example.api_web.customer.dto.CustomerDTO;
import com.example.api_web.customer.model.Customer;
import com.example.api_web.customer.model.mapper.CustomerMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper mapper) {
        this.customerRepository = customerRepository;
        this.mapper = mapper;
    }

    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public CustomerDTO getCustomerById(UUID id) {
        return customerRepository.findById(id).map(mapper::toDTO).orElseThrow(RuntimeException::new);
    }

    @Transactional
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = mapper.toEntity(customerDTO);
        return mapper.toDTO(customerRepository.save(customer));
    }

    @Transactional
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        Customer customer = customerRepository.findById(customerDTO.getId()).orElseThrow(RuntimeException::new);
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setEmail(customerDTO.getEmail());
        Customer updatedCustomer = customerRepository.save(customer);
        return mapper.toDTO(updatedCustomer);
    }

    @Transactional
    public void deleteCustomer(UUID id) {
        customerRepository.deleteById(id);
    }
}
