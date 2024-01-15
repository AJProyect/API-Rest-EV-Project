package com.InditexProject.restApiIxPt.domain.entities;

public class SalesUnitsCriteria extends ProductScoreImpl {
    private double salesUnitWeight;

    public SalesUnitsCriteria(ProductScore productScore, double salesUnitWeight) {
        super(productScore);
        this.salesUnitWeight = salesUnitWeight;
    }

    @Override
    public double calculateScore(Product product) {
        return super.calculateScore(product) + (product.getSalesUnits() * salesUnitWeight);
    }
}
