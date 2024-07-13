package com.alura.forohub.domain.topic.user;

public record UserResponseData(
        Long id,
        String name,
        String email
) {
    public UserResponseData(User user) {
        this(user.getId(), user.getName(), user.getEmail());
    }
}

