package com.mikael.bloggheavencode.controllers;

import com.mikael.bloggheavencode.entities.Blog_Post;
import com.mikael.bloggheavencode.entities.Blog_User;
import com.mikael.bloggheavencode.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * <code>UserController</code> - Controller for Users of the site with corresponding endpoints
 *
 * @author Mikael Eriksson (mikael.eriksson@edu.edugrade.se)
 * @version 0.0.1
 */

@RestController
@Transactional
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/api/posts")
    public List<Blog_Post> getAllUsers(){
        return userService.getAllBlogPosts();
    }

    @GetMapping("/api/posts/{id}")
    @ResponseBody
    public Optional<Blog_Post> getBlogPostByID(@PathVariable Long id){
        return userService.findBlogPostById(id);
    }

    @DeleteMapping("/api/deletepost/{id}")
    @ResponseBody
    public Optional<Blog_Post> deleteBlogPostByID(@PathVariable Long id){
        return userService.deleteBlogPostById(id);
    }

}
