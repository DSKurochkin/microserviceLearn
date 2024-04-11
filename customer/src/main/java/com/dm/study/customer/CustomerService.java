package com.dm.study.customer;

import org.springframework.stereotype.Service;

@Service
public record CustomerService() {
    public void registerCustomer(CustomerRegistrationRequest customerRequest) {
        Customer customer = Customer.builder().
                name(customerRequest.name())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .build();
    }
}
