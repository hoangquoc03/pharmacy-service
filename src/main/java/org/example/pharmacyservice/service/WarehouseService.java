package org.example.pharmacyservice.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import org.example.pharmacyservice.client.WarehouseClient;

import org.springframework.stereotype.Service;



@Service
public class WarehouseService {


    private final WarehouseClient warehouseClient;



    public WarehouseService(
            WarehouseClient warehouseClient
    ){

        this.warehouseClient = warehouseClient;

    }



    @CircuitBreaker(
            name = "warehouseCB",
            fallbackMethod = "warehouseFallback"
    )
    public Integer checkStock(Long medicineId){


        System.out.println(
                "Calling Warehouse-Service..."
        );


        return warehouseClient.checkStock(
                medicineId
        );

    }



    public Integer warehouseFallback(
            Long medicineId,
            Throwable throwable
    ){


        System.out.println(
                "Warehouse Service lỗi: "
                        + throwable.getMessage()
        );


        return 0;

    }

}