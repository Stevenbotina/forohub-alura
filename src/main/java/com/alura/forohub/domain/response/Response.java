package com.alura.forohub.domain.response;


import com.alura.forohub.domain.topic.Topic;
import com.alura.forohub.domain.topic.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Table(name = "responses")
@Entity(name = "Response")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String solution;
    private LocalDateTime creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User author;

    public Response(String message, Topic topic, User user) {
        this.solution = message;
        this.creationDate = LocalDateTime.now();
        this.topic = topic;
        this.author = user;
    }

    public void updateData(UpdateResponseData data) {
        if (data.solution() != null) {
            this.solution = data.solution();
            this.creationDate = LocalDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public String getSolution() {
        return solution;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public Topic getTopic() {
        return topic;
    }

    public User getAuthor() {
        return author;
    }
}

