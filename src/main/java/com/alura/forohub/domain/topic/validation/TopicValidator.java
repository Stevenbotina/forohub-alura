package com.alura.forohub.domain.topic.validation;

import com.alura.forohub.domain.topic.RegisterTopicData;

public interface TopicValidator {
    void validate(RegisterTopicData data);
}

