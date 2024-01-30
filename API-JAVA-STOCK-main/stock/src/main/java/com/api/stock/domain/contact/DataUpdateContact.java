package com.api.stock.domain.contact;

import jakarta.validation.constraints.NotNull;

public record DataUpdateContact(
        @NotNull
        Long id,

        String name,
        String email,
        String number
) {
}
