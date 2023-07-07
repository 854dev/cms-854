package com.mysite.sbb.content.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mysite.sbb.content.entity.ContentType;

public interface ContentTypeRepository extends JpaRepository<ContentType, Integer> {
    ContentType findByContentTypeName(String contentTypeName);
    ContentType findByContentTypeId(int contentTypeId);

}