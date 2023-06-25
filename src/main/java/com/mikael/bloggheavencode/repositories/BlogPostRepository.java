package com.mikael.bloggheavencode.repositories;

import com.mikael.bloggheavencode.entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * <code>BlogPostRepository</code> - Repository that holds BlogPost entities
 *
 * @author Mikael Eriksson (mikael.eriksson@edu.edugrade.se)
 * @version 0.0.1
 */

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost,Long> {
    Optional<BlogPost> findById(Long id);
    Optional<BlogPost> deleteBlog_PostById(Long id);
}
