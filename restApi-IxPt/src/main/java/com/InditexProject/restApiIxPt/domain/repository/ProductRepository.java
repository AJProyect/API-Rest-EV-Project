package com.InditexProject.restApiIxPt.domain.repository;

import com.InditexProject.restApiIxPt.domain.entities.Product;
import org.springframework.data.mongodb.repository.*;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findAllByOrderBySalesUnitsDesc();
    @Aggregation(pipeline = {
            "{$project: {" +
                    "   id: 1," +
                    "   name: 1," +
                    "   salesUnits: 1," +
                    "   stock: 1," +
                    "   totalStock: {$sum: ['$stock.S', '$stock.M', '$stock.L']}" +
                    "}}",
            "{$sort: {totalStock: -1}}"
    })
    List<Product> findAllProductsOrderByTotalStock();
}
