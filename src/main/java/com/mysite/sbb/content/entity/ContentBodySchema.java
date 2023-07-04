package com.mysite.sbb.content.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "content_body_schema")
public class ContentBodySchema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schema_id")
    private Long schemaId;

    @Column(name = "content_type_id")
    private Long contentTypeId;

    @Column(name = "schema_type", length = 100)
    private String schemaType;

    @Column(name = "schema_name", length = 100)
    private String schemaName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "content_type_id", referencedColumnName = "content_type_id", insertable = false, updatable = false)
    private ContentType contentType;

    @OneToMany(mappedBy = "contentBodySchema", cascade = CascadeType.ALL)
    private List<ContentBody> contentBody;

    // Constructors, Getters and Setters
}
