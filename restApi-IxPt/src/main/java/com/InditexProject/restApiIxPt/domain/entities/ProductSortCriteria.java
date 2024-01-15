package com.InditexProject.restApiIxPt.domain.entities;

public class ProductSortCriteria implements ProductScore{
    private ProductScore productScore;

    private ProductSortCriteria(ProductScore productScore){
        this.productScore = productScore;
    }

    public static ProductSortCriteria AddProductSortByStockSales(double salesUnitsWeight, double stockWeight){
        ProductScore productScore = new ProductScoreStandard();
        productScore = new SalesUnitsCriteria(productScore, salesUnitsWeight);
        productScore = new StockCriteria(productScore, stockWeight);

        return new ProductSortCriteria(productScore);
    }
    @Override
    public double calculateScore(Product product) {
        return productScore.calculateScore(product);
    }
}
