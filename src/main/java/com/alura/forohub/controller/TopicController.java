package com.alura.forohub.controller;

import com.alura.forohub.domain.topic.*;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/topics")
@SecurityRequirement(name = "bearer-key")
public class TopicController {

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    TopicService topicService;

    @PostMapping
    @Transactional
    public ResponseEntity<TopicDetailsData> registerTopic(@RequestBody @Valid RegisterTopicData data) {
        var response = topicService.registerTopic(data);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<TopicDetailsData>> listTopics(@PageableDefault(size = 4) Pageable pagination) {
        return ResponseEntity.ok(topicRepository.findByStatusTrue(pagination).map(TopicDetailsData::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicDetailsData> getTopic(@PathVariable Long id) {
        Topic topic = topicRepository.getReferenceById(id);
        var response = new TopicDetailsData(topic);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateTopic(@RequestBody @Valid UpdateTopicData updatedTopic) {
        Topic topic = topicRepository.getReferenceById(updatedTopic.id());
        topic.updateData(updatedTopic);
        var response = new TopicDetailsData(topic);
        return ResponseEntity.ok(response);
    }

    // LOGICAL DELETE
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteTopic(@PathVariable Long id) {
        Topic topic = topicRepository.getReferenceById(id);
        topic.deleteTopic();
        return ResponseEntity.noContent().build();
    }
}

