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

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalesUnits(Integer salesUnits) {
        this.salesUnits = salesUnits;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public int totalStock(){
        return getStock().getS() + getStock().getM() + getStock().getL();
    }

    public double calculateScore(Product product, List<ProductScore> strategies, double... weights) {
        double totalScore = 0;

        for (int i = 0; i < strategies.size(); i++) {
            double weight = i < weights.length ? weights[i] : 0.0;
            totalScore += strategies.get(i).calculateScore(product) * weight;
        }

        return totalScore;
    }

}

