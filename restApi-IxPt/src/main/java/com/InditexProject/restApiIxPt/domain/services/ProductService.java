package com.InditexProject.restApiIxPt.domain.services;

import com.InditexProject.restApiIxPt.domain.entities.Product;
import com.InditexProject.restApiIxPt.domain.entities.ProductScore;
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

    public List<Product> sortProduct(List<ProductScore> strategies, double... weights){
        List<Product> products = repository.findAll();

        return products.stream()
                .sorted(Comparator.comparingDouble((Product p) -> p.calculateScore(p, strategies, weights)).reversed())
                .collect(Collectors.toList());
    }

}
