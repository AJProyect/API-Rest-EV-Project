package com.InditexProject.restApiIxPt.domain.services;

import com.InditexProject.restApiIxPt.domain.entities.Product;
import com.InditexProject.restApiIxPt.domain.entities.ProductScore;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductScoreContext {
    private final List<ProductScore> strategies;

    public ProductScoreContext(List<ProductScore> strategies) {
        this.strategies = strategies;
    }

    public double calculateScore(Product product) {
        double totalScore = 0;

        for (ProductScore strategy : strategies) {
            double score = strategy.calculateScore(product);
            double weight = strategy.getWeight();

            totalScore += score * weight;
        }

        return totalScore;
    }
}

