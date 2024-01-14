package com.InditexProject.restApiIxPt.infrastructure.mapper;

import com.InditexProject.restApiIxPt.infrastructure.dtos.ProductDTO;
import com.InditexProject.restApiIxPt.infrastructure.dtos.StockDTO;
import com.InditexProject.restApiIxPt.domain.entities.Product;
import com.InditexProject.restApiIxPt.domain.entities.Stock;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDTO toDto(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setSalesUnits(product.getSalesUnits());
        dto.setStock(toStockDTO(product.getStock()));
        return dto;
    }

    public Product toDomain(ProductDTO dto) {
        Stock stock = toStockDomain(dto.getStock());
        return new Product(dto.getId(), dto.getName(), dto.getSalesUnits(), stock);
    }

    private StockDTO toStockDTO(Stock stock) {
        StockDTO stockDTO = new StockDTO();
        stockDTO.setS(stock.getS());
        stockDTO.setM(stock.getM());
        stockDTO.setL(stock.getL());
        return stockDTO;
    }

    private Stock toStockDomain(StockDTO stockDTO) {
        return new Stock(stockDTO.getS(), stockDTO.getM(), stockDTO.getL());
    }
}
