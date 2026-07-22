package org.example.pharmacyservice.service;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

import io.github.resilience4j.retry.annotation.Retry;


import org.example.pharmacyservice.client.InvoiceClient;

import org.example.pharmacyservice.dto.InvoiceRequest;
import org.example.pharmacyservice.dto.InvoiceResponse;


import org.springframework.stereotype.Service;



@Service
public class InvoiceService {


    private final InvoiceClient invoiceClient;



    public InvoiceService(
            InvoiceClient invoiceClient
    ){

        this.invoiceClient = invoiceClient;

    }



    @RateLimiter(
            name="invoiceRateLimiter",
            fallbackMethod="invoiceFallback"
    )


    @Retry(
            name="invoiceRetry",
            fallbackMethod="invoiceFallback"
    )


    public InvoiceResponse createInvoice(
            InvoiceRequest request
    ){


        System.out.println(
                "Sending invoice..."
        );


        return invoiceClient.createInvoice(
                request
        );

    }





    public InvoiceResponse invoiceFallback(
            InvoiceRequest request,
            Throwable e
    ){


        System.out.println(
                "Fallback: "
                        + e.getMessage()
        );



        return new InvoiceResponse(
                "Không thể xuất hóa đơn ngay lúc này. "
                        +
                        "Yêu cầu đã được ghi nhận.",
                request.getAmount()
        );

    }


}