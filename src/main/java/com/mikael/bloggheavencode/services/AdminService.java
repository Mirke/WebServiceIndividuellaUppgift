package com.mikael.bloggheavencode.services;

import com.mikael.bloggheavencode.entities.Blog_User;
import com.mikael.bloggheavencode.repositories.BlogUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * <code>AdminService</code> - Service that is a middle person between Admin and Repositories, business logic
 *
 * @author Mikael Eriksson (mikael.eriksson@edu.edugrade.se)
 * @version 0.0.1
 */

@Service
public class AdminService implements IAdminService {

    @Autowired
    private BlogUserRepository blogUserRepository;

    @Override
    public List<Blog_User> getAllUsers() {
        return blogUserRepository.findAll();
    }

    @Override
    public Optional<Blog_User> findBlogUserById(Long id) {
        return blogUserRepository.findById(id);
    }

    @Override
    public void createBlogUser(Blog_User blogUser) {
            blogUserRepository.save(blogUser);
    }


}
