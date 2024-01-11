package com.InditexProject.restApiIxPt.domain.repository;

import com.InditexProject.restApiIxPt.domain.entities.Product;
import org.springframework.data.mongodb.repository.*;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findAll();
}
