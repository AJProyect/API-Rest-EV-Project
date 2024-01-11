package com.InditexProject.restApiIxPt.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Document(collection = "Products")
public class Product {
    @Id
    @NonNull
    private String id;
    private String name;
    @Field("sales_units")
    private int salesUnits;
    @JsonProperty("stock")
    private Stock stock;

    public int totalStock(){
        return getStock().getS() + getStock().getM() + getStock().getL();
    }
}

