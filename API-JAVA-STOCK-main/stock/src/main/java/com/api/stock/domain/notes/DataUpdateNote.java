package com.api.stock.domain.notes;

import jakarta.validation.constraints.NotNull;

public record DataUpdateNote(
        @NotNull
        Long id,

        String title,
        String description
) {
}
