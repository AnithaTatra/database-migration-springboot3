package com.database.migration.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@Table(name = "authors")
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(unique = true, length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(unique = true, length = 100, nullable = false)
    private String email;

    @Column(nullable = false, columnDefinition = "tinyint not null default 0")
    private boolean enabled;

    @CreationTimestamp
    @Column(updatable = false)
    protected Date createdAt;

    @UpdateTimestamp
    protected Date updatedAt;
}
