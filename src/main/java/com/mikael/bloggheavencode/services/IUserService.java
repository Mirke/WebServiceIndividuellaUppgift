package com.mikael.bloggheavencode.services;
import com.mikael.bloggheavencode.entities.BlogPost;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

/**
 * <code>IUserService</code> - Service Interface for Users Service
 *
 * @author Mikael Eriksson (mikael.eriksson@edu.edugrade.se)
 * @version 0.0.1
 */

public interface IUserService {
    List<BlogPost> getAllBlogPosts();
    Optional<BlogPost> findBlogPostById(Long id);
    ResponseEntity<String> deleteBlogPostById(Long id);
    ResponseEntity<String> createBlogPost(BlogPost blogPost);
    ResponseEntity<String> updateBlogPost(Long id, String content);
}
