package com.alura.forohub.domain.response;

import java.time.LocalDateTime;

public record ShowResponseData(
        Long id,
        String author,
        String topicTitle,
        LocalDateTime creationDate,
        String solution
) {
    public ShowResponseData(Response response) {
        this(response.getId(),
                response.getAuthor().getName(),
                response.getTopic().getTitle(),
                response.getCreationDate(),
                response.getSolution());
    }
}

