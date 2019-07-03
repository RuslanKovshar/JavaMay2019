package com.company.service;

import com.company.dto.UsersDTO;
import com.company.entity.Role;
import com.company.entity.User;
import com.company.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collections;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean saveNewUser(User user) {
        try {
            checkUnique(user);
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            user.setActive(true);
            user.setAuthorities(Collections.singleton(Role.USER));
            userRepository.save(user);
            return true;
        } catch (SQLException e) {
            //e.printStackTrace();
            log.info("{this e-mail already exist}");
        }
        return false;
    }

    private void checkUnique(User user) throws SQLException {
        User userByEmail = userRepository.findUserByEmail(user.getEmail());
        if (userByEmail != null) {
            throw new SQLException();
        }
    }

    public UsersDTO getAllUsers() {
        return new UsersDTO(userRepository.findAll());
    }

    private String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    public User getCurrentUser() {
        return userRepository.findUserByEmail(getCurrentUsername());
    }

}
