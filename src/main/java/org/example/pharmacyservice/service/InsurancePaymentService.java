package org.example.pharmacyservice.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;


import org.example.pharmacyservice.client.InsuranceClient;
import org.example.pharmacyservice.dto.PaymentResponse;


import org.springframework.stereotype.Service;


import java.util.concurrent.CompletableFuture;



@Service
public class InsurancePaymentService {


    private final InsuranceClient insuranceClient;



    public InsurancePaymentService(
            InsuranceClient insuranceClient
    ){

        this.insuranceClient = insuranceClient;

    }




    @CircuitBreaker(
            name="insuranceCB",
            fallbackMethod="insuranceFallback"
    )


    @Retry(
            name="insuranceRetry"
    )


    @TimeLimiter(
            name="insuranceTimeout",
            fallbackMethod="insuranceFallback"
    )


    public CompletableFuture<PaymentResponse> payMedicine(
            String insuranceCard,
            double price
    ){


        return CompletableFuture.supplyAsync(() -> {


            Boolean valid =
                    insuranceClient.verifyInsurance(
                            insuranceCard
                    );


            if(valid){

                return new PaymentResponse(
                        price * 0.8,
                        "Áp dụng giảm giá bảo hiểm"
                );

            }



            return new PaymentResponse(
                    price,
                    "Không có bảo hiểm"
            );


        });

    }






    public CompletableFuture<PaymentResponse> insuranceFallback(
            String insuranceCard,
            double price,
            Throwable e
    ){


        return CompletableFuture.completedFuture(

                new PaymentResponse(

                        price,

                        "Xác thực bảo hiểm sau"

                )

        );

    }

}