package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.sbb.content.entity.ContentType;
import com.mysite.sbb.content.repository.ContentTypeRepository;


@SpringBootTest
class ApplicationTests {

    @Autowired
    private ContentTypeRepository contentTypeRepository;

    @Test
    void testJpa() {        
      ContentType ct = contentTypeRepository.findByContentTypeName("testContentType");
        assertEquals("testContentType", ct.getContentTypeName());
    }

    @Test
    void testJpaFindById() {        
      Optional<ContentType> ct = contentTypeRepository.findById(1);
        assertEquals(1, ct.get().getContentTypeId());
    }

}
