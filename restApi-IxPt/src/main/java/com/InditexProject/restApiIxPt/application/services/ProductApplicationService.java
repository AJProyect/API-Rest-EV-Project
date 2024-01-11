package com.InditexProject.restApiIxPt.application.services;

import com.InditexProject.restApiIxPt.domain.entities.Product;
import com.InditexProject.restApiIxPt.domain.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductApplicationService {
    private final ProductService productService;

    @Autowired
    public ProductApplicationService(ProductService productService) {
        this.productService = productService;
    }

    public List<Product> getProductSort(double salesWeight, double stockWeight){
        return productService.sortProduct(salesWeight,stockWeight);
    }
}
