package com.dm.study.customer;

import com.dm.study.appsclients.fraud.FraudCheckResponse;
import com.dm.study.appsclients.fraud.FraudClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;
    private final FraudClient fraudClient;

    public void registerCustomer(CustomerRegistrationRequest customerRequest) {
        Customer customer = Customer.builder().
                name(customerRequest.name())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .build();
        repository.saveAndFlush(customer);

        FraudCheckResponse response = fraudClient.isFraudster(customer.getId());


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
