package com.InditexProject.restApiIxPt.application.services;

import com.InditexProject.restApiIxPt.domain.entities.Product;
import com.InditexProject.restApiIxPt.domain.entities.Stock;
import com.InditexProject.restApiIxPt.domain.services.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductApplicationServiceTest {

    @Autowired
    private ProductApplicationService productApplicationService;

    @MockBean
    private ProductService productService;

    @Test
    public void testGetProductsBySalesUnitsOrdered() {
        List<Product> mockedProducts = Arrays.asList(
                new Product("1", "Product A", 10, new Stock(5, 3, 2)),
                new Product("2", "Product B", 12, new Stock(2, 8, 5)),
                new Product("3", "Product C", 8, new Stock(6, 1, 3))
        );

        when(productService.getProductsBySalesUnits()).thenReturn(mockedProducts);

        List<Product> result = productApplicationService.getProductsBySalesUnits();
        assertNotNull(result);
        assertEquals(mockedProducts.size(), result.size());

        assertEquals(mockedProducts, result);
    }
}
