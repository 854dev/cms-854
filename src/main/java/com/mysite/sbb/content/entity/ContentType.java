package com.mysite.sbb.content.entity;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Where;
import org.hibernate.annotations.SQLDelete;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "content_type")
@SQLDelete(sql = "UPDATE content_type SET deleted_at = CURRENT_TIMESTAMP WHERE content_type_id = ?")
@Where(clause = "deleted_at IS NULL")
public class ContentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_type_id")
    private int contentTypeId;

    @Column(name = "content_type_name", unique = true, length = 100)
    private String contentTypeName;

    @OneToMany(mappedBy = "contentType", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ContentBodySchema> contentBodySchema;

    @Column(name = "deleted_at")
    private Date deletedAt;

    // Getters and Setters

    public int getContentTypeId() {
        return contentTypeId;
    }

    public String getContentTypeName() {
        return contentTypeName;
    }

    public void setContentTypeName(String contentTypeName) {
        this.contentTypeName = contentTypeName;
    }
}
