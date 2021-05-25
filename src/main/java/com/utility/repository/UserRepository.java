package com.utility.repository;


import com.utility.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Harshal Patil
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
