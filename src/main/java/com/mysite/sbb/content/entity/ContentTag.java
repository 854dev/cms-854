package com.mysite.sbb.content.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "content_tag")
public class ContentTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Long tagId;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "content_meta_id")
    private ContentMeta contentMeta;
}
