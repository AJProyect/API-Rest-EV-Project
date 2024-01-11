package com.InditexProject.restApiIxPt.infrastructure.controllers;

import com.InditexProject.restApiIxPt.application.services.ProductApplicationService;
import com.InditexProject.restApiIxPt.domain.entities.Product;
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
    public List<Product> getProductsOrdered(@RequestParam(defaultValue = "sales") String order){
        if ("sales".equalsIgnoreCase(order)) {
            return productApplicationService.getProductsBySalesUnits();
        } else if ("stock".equalsIgnoreCase(order)) {
            return productApplicationService.getProductsByStock();
        } else {
            throw new IllegalArgumentException("Invalid orderBy parameter. Use 'sales' or 'stock'.");
        }
    }
}
