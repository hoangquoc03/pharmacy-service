package org.example.pharmacyservice.controller;

import org.example.pharmacyservice.dto.PaymentResponse;
import org.example.pharmacyservice.service.InsurancePaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {


    private final InsurancePaymentService service;


    public PaymentController(
            InsurancePaymentService service
    ) {

        this.service = service;

    }


    @PostMapping
    public CompletableFuture<PaymentResponse> pay(
            @RequestParam String card,
            @RequestParam double price
    ) {


        return service.payMedicine(
                card,
                price
        );

    }
}