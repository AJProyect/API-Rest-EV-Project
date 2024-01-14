package com.InditexProject.restApiIxPt.application.services;

import com.InditexProject.restApiIxPt.infrastructure.dtos.ProductDTO;
import com.InditexProject.restApiIxPt.infrastructure.mapper.ProductMapper;
import com.InditexProject.restApiIxPt.domain.entities.Product;
import com.InditexProject.restApiIxPt.domain.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductApplicationService {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @Autowired
    public ProductApplicationService(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    public List<Product> getProductSort(double salesWeight, double stockWeight){
        List<Product> products = productService.sortProduct(salesWeight, stockWeight);
        return products;
    }
}
