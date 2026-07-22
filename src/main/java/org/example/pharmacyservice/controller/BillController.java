package org.example.pharmacyservice.controller;

import org.example.pharmacyservice.dto.BillRequest;
import org.example.pharmacyservice.dto.BillResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import org.springframework.web.bind.annotation.*;



@RestController

@RequestMapping("/api/v1/bill")

@RefreshScope

public class BillController {



    @Value("${pharmacy.vat-rate}")
    private double vatRate;



    @PostMapping

    public BillResponse calculateBill(
            @RequestBody BillRequest request
    ){


        double medicineAmount =
                request.getMedicineAmount();



        double vat =
                medicineAmount * vatRate / 100;



        double total =
                medicineAmount + vat;



        return new BillResponse(
                medicineAmount,
                vat,
                total
        );

    }

}