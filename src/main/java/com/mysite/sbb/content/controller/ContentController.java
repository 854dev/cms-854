// package com.mysite.sbb.content.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import com.example.content.dto.CreateContentDto;
// import com.example.content.dto.UpdateContentDto;
// import com.example.content.service.ContentService;
// import com.example.util.TotalPagination;
// import com.example.util.WhereBuilder;

// @RestController
// @RequestMapping("/content")
// public class ContentController {
//     private final ContentService contentService;

//     @Autowired
//     public ContentController(ContentService contentService) {
//         this.contentService = contentService;
//     }

//     @PostMapping
//     public ResponseEntity<?> create(@RequestBody CreateContentDto createContentDto) {
//         contentService.create(createContentDto);
//         return ResponseEntity.status(HttpStatus.CREATED).build();
//     }

//     @GetMapping
//     public ResponseEntity<?> findAll(
//             @RequestParam(value = "page", defaultValue = "1") int page,
//             @RequestParam(value = "limit", defaultValue = "10") int limit,
//             @RequestParam(value = "contentTypeId", required = false) Integer contentTypeId,
//             @RequestParam(value = "contentTypeName", required = false) String contentTypeName) {
//         if (limit > 50) {
//             limit = 50;
//         }

//         if (contentTypeId == null && contentTypeName == null) {
//             throw new IllegalArgumentException("contentTypeId or contentTypeName parameter is required");
//         }

//         WhereBuilder whereBuilder = new WhereBuilder()
//                 .add("contentTypeId", contentTypeId)
//                 .add("contentTypeName", contentTypeName);
//         String where = whereBuilder.build();

//         // Assuming that ContentDto is the DTO for the response
//         List<ContentDto> data = contentService.findManyWithPagination(page, limit, where);
//         int count = contentService.count(where);

//         TotalPagination<ContentDto> result = new TotalPagination<>(data, page, limit, count);
//         return ResponseEntity.ok(result);
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<?> findOne(@PathVariable("id") int id) {
//         ContentDto content = contentService.findOneWithBody(id);
//         return ResponseEntity.ok(content);
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody UpdateContentDto updateContentDto) {
//         contentService.update(id, updateContentDto);
//         return ResponseEntity.ok().build();
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<?> remove(@PathVariable("id") int contentId) {
//         contentService.softDelete(contentId);
//         return ResponseEntity.ok().build();
//     }
// }
