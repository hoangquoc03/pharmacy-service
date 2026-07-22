package org.example.pharmacyservice.dto;

public class PaymentResponse {


    private double medicinePrice;


    private String message;



    public PaymentResponse(
            double medicinePrice,
            String message
    ){

        this.medicinePrice = medicinePrice;

        this.message = message;

    }


    public double getMedicinePrice() {

        return medicinePrice;

    }


    public String getMessage() {

        return message;

    }

}