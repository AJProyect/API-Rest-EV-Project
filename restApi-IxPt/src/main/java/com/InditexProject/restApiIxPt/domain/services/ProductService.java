package com.InditexProject.restApiIxPt.domain.services;

import com.InditexProject.restApiIxPt.domain.entities.Product;
import com.InditexProject.restApiIxPt.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public List<Product> getProductsBySalesUnits() {
        return repository.findAllByOrderBySalesUnitsDesc();
    }

    public List<Product> getProductsByStock() {
        return repository.findAllProductsOrderByTotalStock();
    }
}
