package com.mikael.bloggheavencode.repositories;

import com.mikael.bloggheavencode.entities.Blog_User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogUserRepository extends JpaRepository<Blog_User, Long> {
}
