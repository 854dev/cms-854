package com.mysite.sbb.content.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.mysite.sbb.content.entity.ContentType;
import com.mysite.sbb.content.repository.ContentTypeRepository;

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
}
