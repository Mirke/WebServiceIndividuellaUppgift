package com.mikael.bloggheavencode.controllers;

import com.mikael.bloggheavencode.entities.Blog_User;
import com.mikael.bloggheavencode.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * <code>AdminController</code> - Controller with admin mappings
 *
 * @author Mikael Eriksson (mikael.eriksson@edu.edugrade.se)
 * @version 0.0.1
 */

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/api/users")
    public List<Blog_User> getAllUsers(){
        return adminService.getAllUsers();
    }

    @GetMapping("/api/users/{id}")
    public Optional<Blog_User> getUserByID(@PathVariable Long id){
        return adminService.findBlogUserById(id);
    }

    @PostMapping("/api/newuser")
    public ResponseEntity<String> newUser(@RequestBody Blog_User blogUser){
        try {
            adminService.createBlogUser(blogUser);
            return new ResponseEntity<>("Creating user " + blogUser, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add user ", HttpStatus.BAD_REQUEST);
        }
    }
}
