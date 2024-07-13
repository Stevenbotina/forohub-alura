package com.alura.forohub.domain.topic.user;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationData(
        @NotBlank
        String email,
        @NotBlank
        String password) {

}

