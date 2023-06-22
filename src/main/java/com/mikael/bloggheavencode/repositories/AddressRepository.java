package com.mikael.bloggheavencode.repositories;

import com.mikael.bloggheavencode.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <code>AddressRepository</code> - Repository that holds address entities
 *
 * @author Mikael Eriksson (mikael.eriksson@edu.edugrade.se)
 * @version 0.0.1
 */

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
}
