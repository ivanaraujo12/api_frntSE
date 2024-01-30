package com.api.stock.domain.product;

import jakarta.validation.constraints.NotNull;

public record DataUpdateProduct(
        @NotNull
        Long id,

        String name,
        String code,
        String value
) {
}
