package com.company.service;

import com.company.UserDTO;
import com.company.entity.Role;
import com.company.entity.User;
import com.company.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveNewUser(User user) {
        try {
            checkUnique(user);
            user.setAccountNonExpired(true);
            user.setAccountNonLocked(true);
            user.setCredentialsNonExpired(true);
            user.setEnabled(true);
            user.setAuthorities(Set.of(Role.USER));
            userRepository.save(user);
        } catch (SQLException e) {
            //e.printStackTrace();
            log.info("{this e-mail already exist}");
        }
    }

    private void checkUnique(User user) throws SQLException{
        User userByEmail = userRepository.findUserByEmail(user.getEmail());
        if (userByEmail != null) {
            throw new SQLException();
        }
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(email);
    }
}
