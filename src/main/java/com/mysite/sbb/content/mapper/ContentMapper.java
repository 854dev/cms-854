package com.mysite.sbb.content.mapper;

import org.springframework.stereotype.Component;

import com.mysite.sbb.content.dto.ContentBodySchemaDto;
import com.mysite.sbb.content.entity.ContentBodySchema;
import com.mysite.sbb.content.entity.ContentType;

@Component
public class ContentMapper {
    public ContentBodySchema toEntity (ContentBodySchemaDto dto, ContentType contentType) {
        ContentBodySchema result = new ContentBodySchema();
        result.setSchemaName(dto.getSchemaName());
        result.setSchemaType(dto.getSchemaType());
        result.setContentType(contentType);
        return result;
    }
}
