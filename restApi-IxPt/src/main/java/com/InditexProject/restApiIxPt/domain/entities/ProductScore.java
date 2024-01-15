package com.InditexProject.restApiIxPt.domain.entities;

import org.springframework.stereotype.Component;

@Component
public interface ProductScore {
    public double calculateScore(Product product);
    public double getWeight();
}
