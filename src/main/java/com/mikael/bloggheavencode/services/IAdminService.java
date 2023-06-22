package com.mikael.bloggheavencode.services;

import com.mikael.bloggheavencode.entities.Blog_User;

import java.util.List;

public interface IAdminService {
    List<Blog_User> getAllUsers();
}
