package com.dm.study.customer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    private Integer id;
    private String name;
    private String lastName;
    private String email;
}
