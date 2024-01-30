package com.api.stock.domain.financial;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataCreateFinancial(
        @NotBlank
        String description,

        int value,
        @NotNull
        Stock stock
) {
}
