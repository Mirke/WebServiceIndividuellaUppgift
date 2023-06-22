package com.mikael.bloggheavencode.services;

import com.mikael.bloggheavencode.repositories.BlogUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <code>UserService</code> - Service that is a middle person between Users and Repositories, business logic
 *
 * @author Mikael Eriksson (mikael.eriksson@edu.edugrade.se)
 * @version 0.0.1
 */

@Service
public class UserService implements IUserService{

    @Autowired
    private BlogUserRepository blogUserRepository;


}
