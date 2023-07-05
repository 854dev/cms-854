package com.mysite.sbb.content.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "content_body_schema")
public class ContentBodySchema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schema_id")
    private int schemaId;

    @Column(name = "schema_type", length = 100)
    private String schemaType;

    @Column(name = "schema_name", length = 100)
    private String schemaName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "content_type_id", referencedColumnName = "content_type_id", insertable = true, updatable = false)
    private ContentType contentType;

    @OneToMany(mappedBy = "contentBodySchema", cascade = CascadeType.ALL)
    private List<ContentBody> contentBody;
}
