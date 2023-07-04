package com.mysite.sbb.content.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.mysite.sbb.content.dto.ContentTypeDto;
import com.mysite.sbb.content.entity.ContentType;
import com.mysite.sbb.content.repository.ContentTypeRepository;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ContentTypeService {
    private final ContentTypeRepository contentTypeRepository;

    public Page<ContentType> getListPaged(Pageable page) {
        Pageable pageable = PageRequest.of(page.getPageNumber(), page.getPageSize());
        return this.contentTypeRepository.findAll(pageable);
    }

    @Transactional
    public ContentType create(ContentTypeDto dto) {
        ContentType contentType = dto.toEntity();
        this.contentTypeRepository.save(contentType);
        return contentType;
    }

    @Transactional
    public ContentType update( ContentTypeDto dto) {
        ContentType contentType = dto.toEntity();
        this.contentTypeRepository.update(contentType);
        return contentType;
    }

    @Transactional
    public ContentType delete(ContentTypeDto dto) {
        ContentType contentType = dto.toEntity();
        this.contentTypeRepository.save(contentType);
        return contentType;
    }
}
