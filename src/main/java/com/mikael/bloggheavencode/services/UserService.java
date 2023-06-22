package com.mikael.bloggheavencode.services;

import com.mikael.bloggheavencode.entities.Blog_Post;
import com.mikael.bloggheavencode.entities.Blog_User;
import com.mikael.bloggheavencode.repositories.BlogPostRepository;
import com.mikael.bloggheavencode.repositories.BlogUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * <code>UserService</code> - Service that is a middle person between Users and Repositories, business logic
 *
 * @author Mikael Eriksson (mikael.eriksson@edu.edugrade.se)
 * @version 0.0.1
 */

@Service
public class UserService implements IUserService{

    @Autowired
    private BlogUserRepository userRepository;

    @Autowired
    private BlogPostRepository postRepository;

    @Override
    public List<Blog_Post> getAllBlogPosts() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Blog_Post> findBlogPostById(Long id) {
        return postRepository.findById(id);
    }

    public Optional<Blog_Post> deleteBlogPostById(Long id) {
        return postRepository.deleteBlog_PostById(id);
    }
}
