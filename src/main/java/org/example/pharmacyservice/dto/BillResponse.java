package org.example.pharmacyservice.dto;

public class BillResponse {


    private double medicineAmount;

    private double vat;

    private double total;



    public BillResponse(
            double medicineAmount,
            double vat,
            double total
    ){

        this.medicineAmount = medicineAmount;

        this.vat = vat;

        this.total = total;

    }



    public double getMedicineAmount() {

        return medicineAmount;

    }


    public double getVat() {

        return vat;

    }


    public double getTotal() {

        return total;

    }

}