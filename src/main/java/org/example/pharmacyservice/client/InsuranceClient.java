package org.example.pharmacyservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(
        name="insurance-service",
        url="http://localhost:8084"
)
public interface InsuranceClient {


    @GetMapping("/insurance/check/{card}")
    Boolean verifyInsurance(
            @PathVariable String card
    );

}