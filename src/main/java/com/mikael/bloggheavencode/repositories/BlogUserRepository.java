package com.mikael.bloggheavencode.repositories;

import com.mikael.bloggheavencode.entities.Blog_User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * <code>BlogUserRepository</code> - Repository that holds User entities
 *
 * @author Mikael Eriksson (mikael.eriksson@edu.edugrade.se)
 * @version 0.0.1
 */

@Repository
public interface BlogUserRepository extends JpaRepository<Blog_User, Long> {
    Optional<Blog_User> findById(Long id);
}
