package com.mysite.sbb.content.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;
// import java.util.List;

@Entity
@Table(name = "content_meta")
public class ContentMeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_id")
    private Integer contentId;

    @Column(name = "content_type_id")
    private Integer contentTypeId;

    @Column(name = "content_type_name")
    private String contentTypeName;

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "description", length = 400)
    private String description;

    @Column(name = "creator", length = 100)
    private String creator;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(name = "deleted_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;

    @Column(name = "status", length = 100)
    private String status;

    // @OneToMany(mappedBy = "contentMeta", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // private List<Tag> tags;
}
