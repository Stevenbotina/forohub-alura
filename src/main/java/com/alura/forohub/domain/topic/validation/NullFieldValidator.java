package com.alura.forohub.domain.topic.validation;

import com.alura.forohub.domain.infra.errors.IntegrityValidationException;
import com.alura.forohub.domain.topic.RegisterTopicData;
import org.springframework.stereotype.Component;

@Component
public class NullFieldValidator implements TopicValidator {


    @Override
    public void validate(RegisterTopicData data) {
        if (data.userId() == null) {
            throw new IntegrityValidationException("UserId cannot be null");
        }
        if (data.title() == null) {
            throw new IntegrityValidationException("Title cannot be null");
        }
        if (data.message() == null) {
            throw new IntegrityValidationException("Message cannot be null");
        }
        if (data.course() == null) {
            throw new IntegrityValidationException("Course cannot be null");
        }
    }
}

