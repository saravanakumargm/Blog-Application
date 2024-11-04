package com.gms.blogapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Comment {
    @Id
    @SequenceGenerator(
            name = "comment_sequence",
            sequenceName = "comment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "comment_sequence")
    private int commentId;
    private String userName;
    private String comment;
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "blog_id",nullable = false)
    @JsonIgnore
    private Blog blog;
}
