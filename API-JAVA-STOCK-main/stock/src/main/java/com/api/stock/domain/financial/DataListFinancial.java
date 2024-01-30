package com.api.stock.domain.financial;

public record DataListFinancial(Long id, String description, int value, Stock stock) {
    public DataListFinancial(Financial financial){
        this(financial.getId(), financial.getDescription(), financial.getValue(), financial.getStock());
    }
}
