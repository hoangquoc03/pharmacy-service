package org.example.pharmacyservice.dto;

public class InvoiceRequest {


    private String medicineName;


    private double amount;



    public String getMedicineName() {
        return medicineName;
    }


    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }


    public double getAmount() {
        return amount;
    }


    public void setAmount(double amount) {
        this.amount = amount;
    }

}