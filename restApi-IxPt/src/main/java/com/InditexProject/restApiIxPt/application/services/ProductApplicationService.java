package com.InditexProject.restApiIxPt.application.services;

import com.InditexProject.restApiIxPt.domain.entities.ProductScore;
import com.InditexProject.restApiIxPt.domain.entities.Product;
import com.InditexProject.restApiIxPt.domain.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductApplicationService {
    private final ProductService productService;
    private final List<ProductScore> productStrategies;


    @Autowired
    public ProductApplicationService(ProductService productService, List<ProductScore> productStrategies) {
        this.productService = productService;
        this.productStrategies = productStrategies;
    }

    public List<Product> getProductSort(double... weights){
        return productService.sortProduct(productStrategies, weights);
    }
}
