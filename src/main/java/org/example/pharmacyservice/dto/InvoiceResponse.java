package org.example.pharmacyservice.dto;

public class InvoiceResponse {


    private String message;


    private double amount;



    public InvoiceResponse(
            String message,
            double amount
    ){

        this.message = message;

        this.amount = amount;

    }



    public String getMessage() {

        return message;

    }


    public double getAmount() {

        return amount;

    }

}