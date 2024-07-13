package com.alura.forohub.domain.topic;

import com.alura.forohub.infra.errors.IntegrityValidationException;
import com.alura.forohub.domain.topic.user.User;
import com.alura.forohub.domain.topic.user.UserRepository;

import com.alura.forohub.domain.topic.validation.TopicValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    List<TopicValidator> validators;

    public TopicDetailsData registerTopic(RegisterTopicData data) {
        if (!userRepository.existsById(data.userId())) {
            throw new IntegrityValidationException("User ID not found");
        }

        // Validations
        validators.forEach(v -> v.validate(data));

        User user = userRepository.getReferenceById(data.userId());
        var newTopic = new Topic(data.title(), data.message(), user, data.course());

        topicRepository.save(newTopic);

        return new TopicDetailsData(newTopic);
    }
}

