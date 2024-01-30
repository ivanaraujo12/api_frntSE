package com.api.stock.domain.product;

import jakarta.validation.constraints.NotBlank;

public record DataCreateProduct(
        @NotBlank
        String name,
        @NotBlank
        String code,
        @NotBlank
        String value
) {
}
