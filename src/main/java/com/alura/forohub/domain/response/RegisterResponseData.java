package com.alura.forohub.domain.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterResponseData(
        @NotNull
        Long userId,
        @NotNull
        Long topicId,
        @NotBlank
        String solution
) {
}

