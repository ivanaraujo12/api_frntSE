package com.api.stock.domain.product;


public record DataListProduct(Long id, String name, String code, String value) {
    public DataListProduct(Product product){
        this(product.getId(), product.getName(), product.getCode(), product.getValue());
    }
}
