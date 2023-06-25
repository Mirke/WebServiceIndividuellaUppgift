package com.mikael.bloggheavencode.services;
import com.mikael.bloggheavencode.entities.BlogUser;
import java.util.List;
import java.util.Optional;

/**
 * <code>IAdminService</code> - Service Interface for Admin Service
 *
 * @author Mikael Eriksson (mikael.eriksson@edu.edugrade.se)
 * @version 0.0.1
 */

public interface IAdminService {
    List<BlogUser> getAllUsers();
    Optional<BlogUser> findBlogUserById(Long id);
    void createBlogUser(BlogUser blogUser);
}
