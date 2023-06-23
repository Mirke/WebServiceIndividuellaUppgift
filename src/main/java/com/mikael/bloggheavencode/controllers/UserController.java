package com.mikael.bloggheavencode.controllers;

import com.mikael.bloggheavencode.entities.Blog_Post;
import com.mikael.bloggheavencode.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Optional<Blog_Post> getBlogPostByID(@PathVariable Long id){
        return userService.findBlogPostById(id);
    }

    @DeleteMapping("/api/deletepost/{id}")
    public ResponseEntity<String> deleteBlogPostByID(@PathVariable Long id){
        try{
            userService.deleteBlogPostById(id);
            return new ResponseEntity<>("Deleted blog post with id " + id, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>("Could not delete post with id " + id + " error: " + e.getMessage(), HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("/api/newpost")
    public ResponseEntity<String> createNewPost(@RequestBody Blog_Post blogPost){
        return userService.createBlogPost(blogPost);
    }

    @PutMapping("/api/updatepost/{id}")
    public ResponseEntity<String> updatePost(@PathVariable Long id, @RequestBody Blog_Post blogPost){
        return userService.updateBlogPost(id, blogPost.getContent());
    }

}
