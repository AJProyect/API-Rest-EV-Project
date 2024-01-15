package com.InditexProject.restApiIxPt.application;

import com.InditexProject.restApiIxPt.domain.entities.*;
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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProductServiceTest {
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    private final ProductRepository repository = mock(ProductRepository.class);

    private final StockCriteria salesScoreStrategy = new StockCriteria();
    private final SalesUnitsCriteria stockRatioScoreStrategy = new SalesUnitsCriteria();

    private final List<ProductScore> scoreCalculationStrategies =
            Arrays.asList(salesScoreStrategy, stockRatioScoreStrategy);

    private final ProductService productService = new ProductService(repository);

    @Test
    void testSortProduct() {
        Product product1 = new Product("1", "Product1", 10, new Stock(5, 3, 2));
        Product product2 = new Product("2", "Product2", 8, new Stock(2, 5, 3));
        List<Product> products = Arrays.asList(product1, product2);

        when(repository.findAll()).thenReturn(products);

        List<Product> sortedProducts = productService.sortProduct(scoreCalculationStrategies, 0.3);

        assertEquals(product2, sortedProducts.get(0));
        assertEquals(product1, sortedProducts.get(1));
    }
}

