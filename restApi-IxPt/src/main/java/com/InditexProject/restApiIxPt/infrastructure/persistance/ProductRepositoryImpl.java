package com.InditexProject.restApiIxPt.infrastructure.persistance;

import com.InditexProject.restApiIxPt.domain.entities.Product;
import com.InditexProject.restApiIxPt.domain.repository.ProductRepository;
import com.InditexProject.restApiIxPt.infrastructure.mapper.ProductMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductRepositoryImpl implements ProductRepository {

    private final MongoProductRepository mongoProductRepository;
    private final ProductMapper productMapper;

    public ProductRepositoryImpl(MongoProductRepository mongoProductRepository, ProductMapper productMapper) {
        this.mongoProductRepository = mongoProductRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = mongoProductRepository.findAll().stream().map(productMapper::toDomain).collect(Collectors.toList());
        return products;
    }
}
