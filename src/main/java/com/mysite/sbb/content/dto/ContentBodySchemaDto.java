package com.mysite.sbb.content.dto;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContentBodySchemaDto {
    private int contentTypeId;
    private String schemaName;
    private String schemaType;
}
