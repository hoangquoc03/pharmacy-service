package org.example.pharmacyservice.controller;

import org.example.pharmacyservice.service.WarehouseService;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1/pharmacy")
public class PharmacyController {


    private final WarehouseService warehouseService;



    public PharmacyController(
            WarehouseService warehouseService
    ){

        this.warehouseService = warehouseService;

    }




    @PostMapping("/sell/{medicineId}")
    public String sellMedicine(
            @PathVariable Long medicineId
    ){


        Integer quantity =
                warehouseService.checkStock(
                        medicineId
                );


        if(quantity <= 0){

            return "Không thể bán. Kho không khả dụng";

        }


        return "Bán thuốc thành công";

    }

}