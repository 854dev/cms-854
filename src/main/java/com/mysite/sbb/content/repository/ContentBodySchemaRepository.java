package com.mysite.sbb.content.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysite.sbb.content.entity.ContentBodySchema;

public interface ContentBodySchemaRepository extends JpaRepository<ContentBodySchema, Integer> {
  List<ContentBodySchema> findAll();
}