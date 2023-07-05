package com.mysite.sbb.content.dto;

import com.mysite.sbb.content.entity.ContentType;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContentTypeDto {
    private String contentTypeName;

    public ContentType toEntity () {
        ContentType result = new ContentType();
         result.setContentTypeName(contentTypeName);
        return result;
    }
}
