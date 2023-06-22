package com.mikael.bloggheavencode.services;

import com.mikael.bloggheavencode.entities.Blog_Post;
import com.mikael.bloggheavencode.entities.Blog_User;

import java.util.List;
import java.util.Optional;

/**
 * <code>IUserService</code> - Service Interface for Users Service
 *
 * @author Mikael Eriksson (mikael.eriksson@edu.edugrade.se)
 * @version 0.0.1
 */

public interface IUserService {

    List<Blog_Post> getAllBlogPosts();
    Optional<Blog_Post> findBlogPostById(Long id);
}
