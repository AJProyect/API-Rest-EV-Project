package com.InditexProject.restApiIxPt.infrastructure.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockDTO {
    private int S;
    private int M;
    private int L;

    public StockDTO(int S, int M, int L) {
        this.S = S;
        this.M = M;
        this.L = L;
    }

    public StockDTO() {

    }
}
