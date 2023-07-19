package com.database.migration.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@Table(name = "posts")
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(unique = true, length = 200, nullable = false)
    private String title;

    @Lob
    private String description;

    @Column(nullable = false, columnDefinition = "varchar(10) not null default 'PENDING'")
    @Enumerated(EnumType.STRING)
    private PostStatus status;

    @ManyToOne(targetEntity = Author.class, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "author_id", nullable = false, referencedColumnName = "id")
    private Author author;

    @CreationTimestamp
    @Column(updatable = false)
    protected Date createdAt;

    @UpdateTimestamp
    protected Date updatedAt;
}
