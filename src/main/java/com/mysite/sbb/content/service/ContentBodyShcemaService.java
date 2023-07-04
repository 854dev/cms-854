package com.mysite.sbb.content.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mysite.sbb.content.dto.ContentBodySchemaDto;
import com.mysite.sbb.content.dto.ContentTypeDto;
import com.mysite.sbb.content.entity.ContentBodySchema;
import com.mysite.sbb.content.entity.ContentType;
import com.mysite.sbb.content.repository.ContentBodySchemaRepository;
import com.mysite.sbb.content.repository.ContentTypeRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ContentBodyShcemaService {
    private final ContentBodySchemaRepository contentBodySchemaRepository;

    public List<ContentBodySchema> getAllList() {
        return this.contentBodySchemaRepository.findAll();
    }

    @Transactional
    public ContentBodySchema create(ContentBodySchemaDto dto) {
        ContentBodySchema cbs = dto.toEntity();
        return this.contentBodySchemaRepository.save(cbs);
    }

    @Transactional
    public ContentBodySchema update(int schemaId, ContentBodySchemaDto dto) {
        ContentBodySchema cbs = this.contentBodySchemaRepository.findById(schemaId).get();
        cbs.setSchemaName(dto.getSchemaName());
        cbs.setSchemaType(dto.getSchemaName());
        return this.contentBodySchemaRepository.save(cbs);
    }

    @Transactional
    public ContentBodySchema delete(int schemaId) {
        ContentBodySchema cbs = this.contentBodySchemaRepository.findById(schemaId).get();
        this.contentBodySchemaRepository.delete(cbs);
        return cbs; 
    }
}
