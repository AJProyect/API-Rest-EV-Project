package com.InditexProject.restApiIxPt.infrastructure.persistance;

import com.InditexProject.restApiIxPt.infrastructure.dtos.ProductDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MongoProductRepository extends MongoRepository<ProductDTO, String> {

}
