package com.alura.forohub.domain.topic;

public record TopicDetailsData(
        Long id,
        String user,
        String title,
        String message,
        String course
) {
    public TopicDetailsData(Topic topic) {
        this(topic.getId(), topic.getUser().getName(), topic.getTitle(), topic.getMessage(), topic.getCourse());
    }
}

