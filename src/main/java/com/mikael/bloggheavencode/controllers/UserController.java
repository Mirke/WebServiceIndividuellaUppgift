package com.mikael.bloggheavencode.controllers;
import com.mikael.bloggheavencode.entities.BlogPost;
import com.mikael.bloggheavencode.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import jakarta.transaction.*;
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

    // -----------------------------------------------------------------------------------------------------------------
    //   Server Property
    // -----------------------------------------------------------------------------------------------------------------

    @Autowired
    UserService userService;

    // -----------------------------------------------------------------------------------------------------------------
    //   CRUD Endpoints
    // -----------------------------------------------------------------------------------------------------------------

    @GetMapping("/api/posts")
    @PreAuthorize("hasAnyRole('BLOGGHEAVEN_USER','BLOGGHEAVEN_ADMIN')")
    public List<BlogPost> getAllUsers(){
        return userService.getAllBlogPosts();
    }

    @GetMapping("/api/posts/{id}")
    @PreAuthorize("hasAnyRole('BLOGGHEAVEN_USER','BLOGGHEAVEN_ADMIN')")
    public Optional<BlogPost> getBlogPostByID(@PathVariable Long id){
        return userService.findBlogPostById(id);
    }

    @DeleteMapping("/api/deletepost/{id}")
    @PreAuthorize("hasAnyRole('BLOGGHEAVEN_USER','BLOGGHEAVEN_ADMIN')")
    public ResponseEntity<String> deleteBlogPostByID(@PathVariable Long id){
        return userService.deleteBlogPostById(id);
    }

    @PostMapping("/api/newpost")
    @PreAuthorize("hasAnyRole('BLOGGHEAVEN_USER','BLOGGHEAVEN_ADMIN')")
    public ResponseEntity<String> createNewPost(@RequestBody BlogPost blogPost){
        return userService.createBlogPost(blogPost);
    }

    @PutMapping("/api/updatepost/{id}")
    @PreAuthorize("hasAnyRole('BLOGGHEAVEN_USER','BLOGGHEAVEN_ADMIN')")
    public ResponseEntity<String> updatePost(@PathVariable Long id, @RequestBody BlogPost blogPost){
        return userService.updateBlogPost(id, blogPost.getContent());
    }

}
