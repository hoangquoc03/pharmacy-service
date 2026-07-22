package org.example.pharmacyservice.client;
import org.example.pharmacyservice.dto.InvoiceResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;



@FeignClient(
        name="invoice-service",
        url="http://localhost:8083"
)
public interface InvoiceClient {



    @PostMapping("/invoice/create")
    InvoiceResponse createInvoice(
            @RequestBody Object request
    );

}