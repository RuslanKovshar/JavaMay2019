package com.company.repository;

import com.company.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);

    User findUserById(Long id);
}
