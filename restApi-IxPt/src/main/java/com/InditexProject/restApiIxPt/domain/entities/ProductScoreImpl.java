package com.InditexProject.restApiIxPt.domain.entities;

public class ProductScoreImpl implements ProductScore{
    protected ProductScore productScore;

    public ProductScoreImpl(ProductScore productScore){
        this.productScore = productScore;
    }
    @Override
    public double calculateScore(Product product) {
        return productScore.calculateScore(product);
    }
}
