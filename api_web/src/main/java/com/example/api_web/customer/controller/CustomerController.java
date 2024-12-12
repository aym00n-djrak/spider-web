package com.example.api_web.customer.controller;

import com.example.api_web.customer.dto.CustomerDTO;
import com.example.api_web.customer.service.CustomerServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerDTO> getCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerDTO getCustomer(@PathVariable UUID id) {
        System.out.println("WHESSSSH");
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.createCustomer(customerDTO);
    }

    @PutMapping("/{customerDTO}")
    public CustomerDTO updateCustomer(@PathVariable CustomerDTO customerDTO) {
        return customerService.updateCustomer(customerDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable UUID id) {
        customerService.deleteCustomer(id);
    }
}
