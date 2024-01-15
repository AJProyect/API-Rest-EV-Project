package com.InditexProject.restApiIxPt.domain.entities;



public class StockCriteria extends ProductScoreImpl{
    private double stockWeight;

    public StockCriteria(ProductScore productScore, double stockWeight) {
        super(productScore);
        this.stockWeight = stockWeight;
    }

    @Override
    public double calculateScore(Product product) {
        return super.calculateScore(product) + (product.totalStock() * stockWeight);
    }
}
