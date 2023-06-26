package com.mikael.bloggheavencode.services;
import com.mikael.bloggheavencode.entities.BlogUser;
import com.mikael.bloggheavencode.repositories.BlogUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    // -----------------------------------------------------------------------------------------------------------------
    //   Repository Property
    // -----------------------------------------------------------------------------------------------------------------

    @Autowired
    private BlogUserRepository blogUserRepository;

    // -----------------------------------------------------------------------------------------------------------------
    //   Service Methods
    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public List<BlogUser> getAllUsers() {
        return blogUserRepository.findAll();
    }

    @Override
    public Optional<BlogUser> findBlogUserById(Long id) {
        return blogUserRepository.findById(id);
    }

    @Override
    public ResponseEntity<String> createNewUser(BlogUser blogUser) {
        try {
            blogUserRepository.save(blogUser);
            return new ResponseEntity<>("Creating user: " + blogUser.getFirstName() + " " + blogUser.getLastName(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("FAILED to create user. ", HttpStatus.BAD_REQUEST);
        }
    }

}
