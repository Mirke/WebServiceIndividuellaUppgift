package com.mikael.bloggheavencode.repositories;

import com.mikael.bloggheavencode.entities.Blog_Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends JpaRepository<Blog_Post,Long> {
}
