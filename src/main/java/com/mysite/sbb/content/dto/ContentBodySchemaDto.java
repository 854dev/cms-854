package com.mysite.sbb.content.dto;

import com.mysite.sbb.content.entity.ContentBodySchema;
import com.mysite.sbb.content.entity.ContentType;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContentBodySchemaDto {
    private ContentType contentType;
    private String schemaName;
    private String schemaType;

    public ContentBodySchema toEntity () {
        ContentBodySchema result = new ContentBodySchema();
        result.setSchemaName(schemaName);
        result.setSchemaType(schemaType);
        result.setContentType(contentType);
        return result;
    }
}
