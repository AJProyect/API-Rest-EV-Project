package com.InditexProject.restApiIxPt.infrastructure.controllers;

import com.InditexProject.restApiIxPt.application.services.ProductApplicationService;
import com.InditexProject.restApiIxPt.domain.entities.Product;
import com.InditexProject.restApiIxPt.domain.entities.ProductSortCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {

    private final ProductApplicationService productApplicationService;

    @Autowired
    public ProductController(ProductApplicationService productApplicationService) {
        this.productApplicationService = productApplicationService;
    }

    @GetMapping(value = "/filtered", produces = "application/json")
    public List<Product> getProductsOrdered(@RequestParam double salesWeight, @RequestParam double stockWeight){
        validateWeights(salesWeight, stockWeight);
        ProductSortCriteria strategies = ProductSortCriteria.AddProductSortByStockSales(salesWeight, stockWeight);
        return productApplicationService.getProductSort(strategies);
    }

    private void validateWeights(double salesWeight, double stockWeight){
        if (salesWeight < 0 || stockWeight < 0) {
            throw new IllegalArgumentException("Params cannot be negative.");
        }
    }
}
