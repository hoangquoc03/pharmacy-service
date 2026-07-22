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
            fallbackMethod = "checkWarehouseFallback"
    )
    public String checkStock(Long medicineId){


        Integer quantity =
                warehouseClient.checkStock(medicineId);


        return "Kho tổng còn: "
                + quantity
                + " sản phẩm";

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
    public String checkWarehouseFallback(
            Long medicineId,
            Throwable e
    ){


        System.out.println(
                "Warehouse lỗi: "
                        + e.getMessage()
        );


        return "Không thể kết nối kho tổng. "
                + "Hệ thống sẽ sử dụng dữ liệu tồn kho cục bộ "
                + "để tiếp tục giao dịch";

    }

}