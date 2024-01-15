package com.InditexProject.restApiIxPt.domain.entities;

import org.springframework.stereotype.Component;

@Component
public class SalesUnitsCriteria implements ProductScore {

    @Override
    public double calculateScore(Product product) {
        return product.getSalesUnits();
    }

    @Override
    public double getWeight() {
        return 0.7;
    }
}
