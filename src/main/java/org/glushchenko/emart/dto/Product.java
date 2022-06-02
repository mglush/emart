package org.glushchenko.emart.dto;

import java.math.BigDecimal;

public class Product {
    String id;
    String modelNumber;
    String categoryName;
    BigDecimal warranty;
    BigDecimal price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public BigDecimal getWarranty() {
        return warranty;
    }

    public void setWarranty(BigDecimal warranty) {
        this.warranty = warranty;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "stock number='" + id + '\'' +
                ", model number='" + modelNumber + '\'' +
                ", category name='" + categoryName + '\'' +
                ", warranty='" + warranty + '\'' +
                ", price=" + price +
                '}';
    }

    public String partialToString() {
        return "Product{" +
                "stock number='" + id + '\'' +
                ", price=" + price +
                ", count=" + warranty +
                '}';
    }
}
