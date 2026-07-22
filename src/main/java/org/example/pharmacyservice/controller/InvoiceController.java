package org.example.pharmacyservice.controller;

import org.example.pharmacyservice.dto.InvoiceRequest;
import org.example.pharmacyservice.dto.InvoiceResponse;
import org.example.pharmacyservice.service.InvoiceService;


import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1/invoice")
public class InvoiceController {


    private final InvoiceService invoiceService;



    public InvoiceController(
            InvoiceService invoiceService
    ){

        this.invoiceService = invoiceService;

    }



    @PostMapping
    public InvoiceResponse create(
            @RequestBody InvoiceRequest request
    ){

        return invoiceService.createInvoice(
                request
        );

    }

}