package com.InditexProject.restApiIxPt.domain.entities;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter

public class Product {
    @Id
    @NonNull
    private String id;
    private String name;
    private int salesUnits;
    private Stock stock;

    public Product(@NonNull String id, String name, int salesUnits, Stock stock){
        this.id = id;
        this.name = name;
        this.salesUnits = salesUnits;
        this.stock = stock;
    }

    public int totalStock(){
        return getStock().getS() + getStock().getM() + getStock().getL();
    }

    public double calculateScore(double salesWeight, double stockWeight) {
        double salesScore = salesUnits * salesWeight;
        double stockScore = totalStock() * stockWeight;
        return salesScore + stockScore;
    }
}

