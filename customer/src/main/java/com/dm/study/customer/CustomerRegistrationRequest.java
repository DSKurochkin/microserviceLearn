package com.dm.study.customer;

public record CustomerRegistrationRequest(
        String name,
        String lastName,
        String email
) {
}
