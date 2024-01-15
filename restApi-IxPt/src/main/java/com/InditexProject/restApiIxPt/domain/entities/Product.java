package com.InditexProject.restApiIxPt.domain.entities;

import java.util.List;

public class Product {
    private String id;
    private String name;
    private int salesUnits;
    private Stock stock;


    public Product(String id, String name, int salesUnits, Stock stock){
        this.id = id;
        this.name = name;
        this.salesUnits = salesUnits;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getSalesUnits() {
        return salesUnits;
    }

    public Stock getStock() {
        return stock;
    }

    public int totalStock(){
        return getStock().getS() + getStock().getM() + getStock().getL();
    }

    public double calculateScore(ProductSortCriteria strategies) {
        return strategies.calculateScore(this);
    }

}

