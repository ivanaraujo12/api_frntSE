package com.api.stock.domain.financial;

public record DataDetailsFinancial(Long id, String description, int value, Stock stock, Boolean active) {
    public DataDetailsFinancial(Financial financial){
        this(financial.getId(), financial.getDescription(), financial.getValue(), financial.getStock(), financial.getActive());
    }
}
