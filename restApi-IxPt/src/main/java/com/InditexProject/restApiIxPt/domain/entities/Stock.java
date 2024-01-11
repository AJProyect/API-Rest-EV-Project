package com.InditexProject.restApiIxPt.domain.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Stock {
    private int S;
    private int M;
    private int L;

    public Stock(int S, int M, int L) {
        this.S = S;
        this.M = M;
        this.L = L;
    }
}
