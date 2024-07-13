package com.alura.forohub.domain.response;


import com.alura.forohub.domain.infra.errors.IntegrityValidationException;
import com.alura.forohub.domain.topic.Topic;
import com.alura.forohub.domain.topic.TopicRepository;
import com.alura.forohub.domain.topic.user.User;
import com.alura.forohub.domain.topic.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ResponseService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    ResponseRepository responseRepository;

    public ShowResponseData registerResponse(RegisterResponseData data) {
        if (!userRepository.existsById(data.userId())) {
            throw new IntegrityValidationException("User ID not found");
        }

        if (!topicRepository.existsById(data.topicId())) {
            throw new IntegrityValidationException("Topic ID not found");
        }

        User user = userRepository.getReferenceById(data.userId());
        Topic topic = topicRepository.getReferenceById(data.topicId());

        Response newResponse = new Response(data.solution(), topic, user);
        responseRepository.save(newResponse);

        return new ShowResponseData(newResponse);
    }
}

