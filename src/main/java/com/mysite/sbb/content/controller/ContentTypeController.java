package com.mysite.sbb.content.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.sbb.content.dto.ContentTypeDto;
import com.mysite.sbb.content.entity.ContentType;
import com.mysite.sbb.content.service.ContentTypeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/content-type")
public class ContentTypeController {
      
  private final ContentTypeService contentTypeService;

  @GetMapping
  @ResponseBody
    public ResponseEntity<Page<ContentType>> findAllPaged(
        @RequestParam(value = "page", defaultValue = "1") int page,
        @RequestParam(value = "size", defaultValue = "10") int size
      ) {
        if (size > 50) { size = 50; }
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<ContentType> contentTypePage = contentTypeService.getListPaged(pageable);
        return ResponseEntity.ok(contentTypePage);
    }

  @PostMapping
  @ResponseBody
  public ContentType create(@RequestBody ContentTypeDto dto) {
      return this.contentTypeService.create(dto);
  }

  @PutMapping("/{contentTypeId}")
  @ResponseBody
  public ContentType update(@RequestBody ContentTypeDto dto, @PathVariable int contentTypeId) {
      return this.contentTypeService.update(contentTypeId, dto);
  }

  @DeleteMapping("/{contentTypeId}")
  @ResponseBody
  public ContentType delete(@PathVariable int contentTypeId) {
      return this.contentTypeService.delete(contentTypeId);
  }
}
