package com.alura.forohub.domain.response;

import jakarta.validation.constraints.NotNull;

public record UpdateResponseData(
        @NotNull
        Long id,
        String solution
) {
}

