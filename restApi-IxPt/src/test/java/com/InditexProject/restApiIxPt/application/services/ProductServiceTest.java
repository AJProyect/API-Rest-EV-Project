package com.InditexProject.restApiIxPt.application.services;

import com.InditexProject.restApiIxPt.domain.entities.Product;
import com.InditexProject.restApiIxPt.domain.entities.Stock;
import com.InditexProject.restApiIxPt.domain.repository.ProductRepository;
import com.InditexProject.restApiIxPt.domain.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ProductServiceTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSortProduct() {
        Product product1 = new Product("1", "Product1", 10, new Stock(5, 3, 2));
        Product product2 = new Product("2", "Product2", 8, new Stock(2, 5, 3));
        List<Product> products = Arrays.asList(product1, product2);

        when(repository.findAll()).thenReturn(products);

        List<Product> sortedProducts = productService.sortProduct(0.5, 0.3);

        assertEquals(product2, sortedProducts.get(0));
        assertEquals(product1, sortedProducts.get(1));
    }

}

