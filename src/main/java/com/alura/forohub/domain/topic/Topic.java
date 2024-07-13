package com.alura.forohub.domain.topic;

import com.alura.forohub.domain.topic.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topics")
@Entity(name = "Topic")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String title;

    @Column(unique = true)
    private String message;

    private LocalDateTime date;
    private Boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String course;

    public Topic(String title, String message, User user, String course) {
        this.title = title;
        this.message = message;
        this.date = LocalDateTime.now();
        this.status = true;
        this.user = user;
        this.course = course;
    }

    public void updateData(UpdateTopicData data) {
        if (data.title() != null) {
            this.title = data.title();
        }
        if (data.message() != null) {
            this.message = data.message();
        }
        if (data.course() != null) {
            this.course = data.course();
        }
    }

    public void deleteTopic() {
        this.status = false;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Boolean getStatus() {
        return status;
    }

    public User getUser() {
        return user;
    }

    public String getCourse() {
        return course;
    }
}

