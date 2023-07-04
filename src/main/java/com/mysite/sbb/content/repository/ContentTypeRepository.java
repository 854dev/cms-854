package com.mysite.sbb.content.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mysite.sbb.content.entity.ContentType;

public interface ContentTypeRepository extends JpaRepository<ContentType, Integer> {
    ContentType findByContentTypeName(String contentTypeName);
    ContentType findByContentTypeId(int contentTypeId);
}