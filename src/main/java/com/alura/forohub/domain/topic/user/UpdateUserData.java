package com.alura.forohub.domain.topic.user;

import jakarta.validation.constraints.NotNull;

public record UpdateUserData(
        @NotNull
        Long id,
        String name,
        String password
) {
}

