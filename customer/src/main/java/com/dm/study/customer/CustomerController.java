package com.dm.study.customer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRequest) {
        log.info("new customer registrations {}", customerRequest);
        customerService.registerCustomer(customerRequest);
    }

    @GetMapping("/test")
    public String test(){
        return "CustomerController available";
    }
}
