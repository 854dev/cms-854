package com.mysite.sbb.content.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
        if (size > 50) {
            size = 50;
        }

        Pageable pageable = PageRequest.of(page - 1, size);
        Page<ContentType> contentTypePage = contentTypeService.getListPaged(pageable);
        return ResponseEntity.ok(contentTypePage);
    }
}
