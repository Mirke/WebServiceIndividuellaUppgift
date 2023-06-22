package com.mikael.bloggheavencode.controllers;

import com.mikael.bloggheavencode.entities.Blog_User;
import com.mikael.bloggheavencode.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
