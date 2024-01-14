package com.InditexProject.restApiIxPt.domain.entities;

public class Stock {
    private final int S;
    private final int M;
    private final int L;

    public Stock(int S, int M, int L) {
        this.S = S;
        this.M = M;
        this.L = L;
    }

    public int getS() {
        return S;
    }

    public int getM() {
        return M;
    }

    public int getL() {
        return L;
    }
}
