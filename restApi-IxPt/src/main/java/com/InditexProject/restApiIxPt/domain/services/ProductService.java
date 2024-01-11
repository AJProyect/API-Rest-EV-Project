package com.InditexProject.restApiIxPt.domain.services;

import com.InditexProject.restApiIxPt.domain.entities.Product;
import com.InditexProject.restApiIxPt.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public List<Product> sortProduct(double salesWeight, double stockWeight){
        List<Product> products = repository.findAll();

        return products.stream().sorted(Comparator.comparingDouble((Product p) -> getScore(p, salesWeight, stockWeight)).reversed())
                .collect(Collectors.toList());
    }

    public double getScore(Product product, double salesWeight, double stockWeight){
        double salesScore = product.getSalesUnits() * salesWeight;
        double stockScore = product.totalStock() * stockWeight;

        return salesScore + stockScore;
    }
}
