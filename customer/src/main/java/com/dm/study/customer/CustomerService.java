package com.dm.study.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository repository;
    private final RestTemplate restTemplate;

    public void registerCustomer(CustomerRegistrationRequest customerRequest) {
        Customer customer = Customer.builder().
                name(customerRequest.name())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .build();
        repository.saveAndFlush(customer);
        FraudCheckResponse response = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );
        if (response == null) {
            throw new RuntimeException("response from Fraud Service is null");
        }
        if (response.isFraudster()) {
            throw new IllegalStateException("this customer is fraudster");
        }

        //todo check email on valid
        //todo check email on exist
        //todo check that customer is not spy


    }
}
