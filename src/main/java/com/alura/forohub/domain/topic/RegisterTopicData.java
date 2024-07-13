package com.alura.forohub.domain.topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterTopicData(
        @NotNull
        Long userId,
        @NotBlank
        String title,
        @NotBlank
        String message,
        @NotBlank
        String course
) {
}

