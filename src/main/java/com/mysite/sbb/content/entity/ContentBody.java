package com.mysite.sbb.content.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "content_body")
public class ContentBody {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "content_id")
    private Long contentId;

    @Column(name = "schema_name", length = 100)
    private String schemaName;

    @Column(name = "schema_value", columnDefinition = "text")
    private String schemaValue;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "content_body_schema_id")
    private ContentBodySchema contentBodySchema;

    // Constructors, Getters and Setters
}

