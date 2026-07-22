package org.example.pharmacyservice.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;



@Component

public class BranchConfig {


    @Value("${app.branch-name}")

    private String branchName;



    @Value("${app.hotline}")

    private String hotline;



    @PostConstruct

    public void printInfo(){


        System.out.println("========================");

        System.out.println(
                "Chi nhánh: " + branchName
        );


        System.out.println(
                "Hotline: " + hotline
        );


        System.out.println("========================");


    }

}