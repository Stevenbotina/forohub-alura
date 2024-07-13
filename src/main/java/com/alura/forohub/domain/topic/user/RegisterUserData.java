package com.alura.forohub.domain.topic.user;

import jakarta.validation.constraints.NotBlank;

public record RegisterUserData(
        @NotBlank
        String email,
        @NotBlank
        String name,
        @NotBlank
        String password
) {
}

