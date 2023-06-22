package com.mikael.bloggheavencode.repositories;

import com.mikael.bloggheavencode.entities.Blog_Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <code>BlogPostRepository</code> - Repository that holds BlogPost entities
 *
 * @author Mikael Eriksson (mikael.eriksson@edu.edugrade.se)
 * @version 0.0.1
 */

@Repository
public interface BlogPostRepository extends JpaRepository<Blog_Post,Long> {
}
