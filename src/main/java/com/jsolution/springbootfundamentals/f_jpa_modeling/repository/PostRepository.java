package com.jsolution.springbootfundamentals.f_jpa_modeling.repository;

import com.jsolution.springbootfundamentals.f_jpa_modeling.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
