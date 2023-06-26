package com.mikael.bloggheavencode.controllers;
import com.mikael.bloggheavencode.entities.BlogUser;
import com.mikael.bloggheavencode.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/api")
public class AdminController {

    // -----------------------------------------------------------------------------------------------------------------
    //   Server Property
    // -----------------------------------------------------------------------------------------------------------------

    @Autowired
    private AdminService adminService;

    // -----------------------------------------------------------------------------------------------------------------
    //   CRUD Endpoints
    // -----------------------------------------------------------------------------------------------------------------

    @GetMapping("/users")
    @PreAuthorize("hasRole('BLOGGHEAVEN_ADMIN')")
    public List<BlogUser> getAllUsers() {
        return adminService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    @PreAuthorize("hasRole('BLOGGHEAVEN_ADMIN')")
    public Optional<BlogUser> getUserByID(@PathVariable Long id) {
        return adminService.findBlogUserById(id);
    }

    @PostMapping("/newuser")
    @PreAuthorize("hasRole('BLOGGHEAVEN_ADMIN')")
    public ResponseEntity<String> newUser(@RequestBody BlogUser blogUser) {
        return adminService.createNewUser(blogUser);
    }
}
