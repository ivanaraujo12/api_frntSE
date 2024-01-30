package com.api.stock.domain.contact;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DataCreateContact(
        @NotBlank
        String name,
        @Email
        @NotBlank
        String email,
        @NotBlank
        String number
) {
}
