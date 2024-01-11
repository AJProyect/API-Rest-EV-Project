package com.InditexProject.restApiIxPt.domain.repository;

import com.InditexProject.restApiIxPt.domain.entities.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
}
