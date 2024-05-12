package com.dm.study.appsclients.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "fraud",
        url = "http://fraud:8081"
//        url = "${clients.fraud.url}" prop dont work
)
public interface FraudClient {
    @GetMapping("api/v1/fraud-check/{customerId}")
    FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId);
}
