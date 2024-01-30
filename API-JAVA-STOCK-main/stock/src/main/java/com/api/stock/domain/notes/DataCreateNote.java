package com.api.stock.domain.notes;

import jakarta.validation.constraints.NotBlank;

public record DataCreateNote(
        @NotBlank
        String title,
        @NotBlank
        String description
) {
}
