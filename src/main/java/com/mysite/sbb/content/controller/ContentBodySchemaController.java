package com.mysite.sbb.content.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.sbb.content.dto.ContentBodySchemaDto;
import com.mysite.sbb.content.entity.ContentBodySchema;
import com.mysite.sbb.content.entity.ContentType;
import com.mysite.sbb.content.mapper.ContentMapper;
import com.mysite.sbb.content.service.ContentBodyShcemaService;
import com.mysite.sbb.content.service.ContentTypeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/content-body-schema")
public class ContentBodySchemaController {
      
  private final ContentBodyShcemaService contentBodyShcemaService;
  private final ContentTypeService contentTypeService;
  private final ContentMapper contentMapper;

  @GetMapping
  @ResponseBody
  public ResponseEntity<List<ContentBodySchema>> findAll() {
      List<ContentBodySchema> results = contentBodyShcemaService.getAllList();
      return ResponseEntity.ok(results);
  }

  @PostMapping
  @ResponseBody
  public ContentBodySchema create(@RequestBody ContentBodySchemaDto dto) {
      ContentType ct = contentTypeService.findByContentTypeId(dto.getContentTypeId());
      ContentBodySchema cbs = contentMapper.toEntity(dto, ct);
      return this.contentBodyShcemaService.create(cbs);
  }

  @DeleteMapping("/{schemaId}")
  @ResponseBody
  public ContentBodySchema delete(@PathVariable int schemaId) {
      return this.contentBodyShcemaService.delete(schemaId);
  }
}

