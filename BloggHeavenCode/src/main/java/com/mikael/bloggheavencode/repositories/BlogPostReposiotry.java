package com.mikael.bloggheavencode.repositories;

import com.mikael.bloggheavencode.entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostReposiotry extends JpaRepository<BlogPost,Long> {
}
