package com.api.stock.domain.product;

public record DataDetailsProduct(Long id, String name, String code, String value, Boolean active) {
    public DataDetailsProduct(Product product){
        this(product.getId(), product.getName(), product.getCode(), product.getValue(), product.getActive());
    }
}
