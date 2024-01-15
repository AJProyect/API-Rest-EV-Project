package com.InditexProject.restApiIxPt.application;

import com.InditexProject.restApiIxPt.domain.entities.Product;
import com.InditexProject.restApiIxPt.domain.entities.ProductSortCriteria;
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
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSortProduct() {
        // Arrange
        Product product1 = new Product("1", "Product1", 10, new Stock(5, 3, 7));
        Product product2 = new Product("2", "Product2", 15, new Stock(2, 8, 6));

        when(productRepository.findAll()).thenReturn(Arrays.asList(product1, product2));

        ProductSortCriteria sortCriteria = ProductSortCriteria.AddProductSortByStockSales(0.6, 0.4);

        // Act
        List<Product> sortedProducts = productService.sortProduct(sortCriteria);

        // Assert
        assertEquals("2", sortedProducts.get(0).getId());
        assertEquals("1", sortedProducts.get(1).getId());

    }
}

