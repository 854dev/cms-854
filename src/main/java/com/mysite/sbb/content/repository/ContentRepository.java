// package com.mysite.sbb.content.repository;

// import java.util.List;

// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.jpa.domain.Specification;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;

// import com.mysite.sbb.content.entity.ContentMeta;

// public interface ContentMetaRepository extends JpaRepository<ContentMeta, Integer> {
//     Page<ContentMeta> findAll(Pageable pageable);
//     Page<ContentMeta> findAll(Specification<ContentMeta> spec, Pageable pageable);
//     ContentMeta findByContentTypeName(Specification<ContentMeta> spec, Pageable pageable);
// }