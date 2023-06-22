package com.mikael.bloggheavencode.repositories;

import com.mikael.bloggheavencode.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepositories extends JpaRepository<Address,Long> {
}
