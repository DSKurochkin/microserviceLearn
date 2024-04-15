package com.dm.study.customer;

import com.dm.study.appsclients.fraud.FraudCheckResponse;
import com.dm.study.appsclients.fraud.FraudClient;
import com.dm.study.appsclients.notification.NotificationClient;
import com.dm.study.appsclients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;

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

        notificationClient.sendNotification(
                new NotificationRequest(
                        customer.getId(),
                        customer.getEmail(),
                        "My notification service is worked",
                        "Best friend",
                        LocalDateTime.now()
                )
        );

        //todo check email on valid
        //todo check email on exist
        //todo check that customer is not spy


    }
}
