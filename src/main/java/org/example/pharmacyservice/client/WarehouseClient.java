package org.example.pharmacyservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(
        name = "warehouse-service",
        url = "http://localhost:8082"
)
public interface WarehouseClient {


    @GetMapping("/warehouse/check/{medicineId}")
    Integer checkStock(
            @PathVariable Long medicineId
    );

}