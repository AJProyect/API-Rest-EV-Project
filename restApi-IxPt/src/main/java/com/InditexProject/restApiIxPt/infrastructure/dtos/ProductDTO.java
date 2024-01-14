package com.InditexProject.restApiIxPt.infrastructure.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Document(collection = "Products")
public class ProductDTO {
    private String id;
    private String name;
    @Field("sales_units")
    private int salesUnits;
    private StockDTO stock;

    public ProductDTO(){

    }
}
