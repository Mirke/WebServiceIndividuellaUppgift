package com.mikael.bloggheavencode.services;

import com.mikael.bloggheavencode.entities.Blog_User;
import com.mikael.bloggheavencode.repositories.BlogUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService implements IAdminService {

    @Autowired
    private BlogUserRepository blogUserRepository;


    @Override
    public List<Blog_User> getAllUsers() {
        return blogUserRepository.findAll();
    }
}
