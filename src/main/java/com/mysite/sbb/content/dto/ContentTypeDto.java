package com.mysite.sbb.content.dto;

public class ContentTypeDto {
    private String contentTypeName;

    public ContentTypeDto(String contentTypeName) {
        this.contentTypeName = contentTypeName;
    }

    public String getContentTypeName() {
        return contentTypeName;
    }

    public void setContentTypeName(String contentTypeName) {
        this.contentTypeName = contentTypeName;
    }
}
