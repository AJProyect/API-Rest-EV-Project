package com.InditexProject.restApiIxPt.domain.entities;

import org.springframework.stereotype.Component;

@Component
public class StockCriteria implements ProductScore{

    @Override
    public double calculateScore(Product product) {
        return product.totalStock();
    }

    @Override
    public double getWeight() {
        return 0.3;
    }
}
