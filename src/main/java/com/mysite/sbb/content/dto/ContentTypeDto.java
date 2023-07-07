package com.mysite.sbb.content.dto;

import java.util.List;

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
public class ContentTypeDto {
    private int contentTypeId;
    private String contentTypeName;
    private List<ContentBodySchema> contentBodySchema;

    public static ContentTypeDto fromEntity (ContentType contentType) {
        return new ContentTypeDto(
            contentType.getContentTypeId(),
            contentType.getContentTypeName(),
            contentType.getContentBodySchema()
        );
    }


    public ContentType toEntity () {
        ContentType result = new ContentType();
         result.setContentTypeName(contentTypeName);
        return result;
    }
}
