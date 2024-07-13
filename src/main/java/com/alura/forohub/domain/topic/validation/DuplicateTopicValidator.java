package com.alura.forohub.domain.topic.validation;

import com.alura.forohub.domain.topic.RegisterTopicData;
import com.alura.forohub.domain.topic.TopicRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DuplicateTopicValidator implements TopicValidator {

    @Autowired
    TopicRepository topicRepository;


    @Override
    public void validate(RegisterTopicData data) {
        var titleExists = topicRepository.existsByTitle(data.title());
        var messageExists = topicRepository.existsByMessage(data.message());

        if (titleExists && messageExists) {
            throw new ValidationException("The topic is duplicated. Please enter a different topic.");
        }
    }
}

