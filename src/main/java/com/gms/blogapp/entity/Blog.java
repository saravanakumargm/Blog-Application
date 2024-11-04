package com.gms.blogapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
@Entity
@Getter
@Setter
@ToString(exclude = "users")
@EqualsAndHashCode(exclude = "users")
@Data
public class Blog {
    @Id
    @SequenceGenerator(
            name = "blog_sequence",
            sequenceName = "blog_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "blog_sequence")
    private Long id;
    private String title;
    private String category;
    private String content;
    private LocalDateTime timestamp;
    @OneToMany(mappedBy = "blog")
    private List<Comment> comments;

}
