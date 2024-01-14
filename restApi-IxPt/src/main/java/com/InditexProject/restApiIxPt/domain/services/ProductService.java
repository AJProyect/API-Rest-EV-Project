package com.InditexProject.restApiIxPt.domain.services;

import com.InditexProject.restApiIxPt.domain.entities.Product;
import com.InditexProject.restApiIxPt.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> sortProduct(double salesWeight, double stockWeight){
        List<Product> products = repository.findAll();

        return products.stream()
                .sorted(Comparator.comparingDouble((Product p) -> p.calculateScore(salesWeight, stockWeight)).reversed())
                .collect(Collectors.toList());
    }

}
