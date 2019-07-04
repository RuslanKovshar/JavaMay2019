package com.company.service;

import com.company.dto.UserDTO;
import com.company.dto.UsersDTO;
import com.company.entity.Role;
import com.company.entity.User;
import com.company.exceptions.IncorrectDataException;
import com.company.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Slf4j
@Service
public class UserService{

    private UserRepository userRepository;

    private UserDTO userDTO;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public boolean test(UserDTO userDTO) {
        try {
            saveNewUser(userDTO);
            return true;
        } catch (IncorrectDataException e) {
            log.info("{incorrect data}");
           // e.printStackTrace();
        }
        return false;
    }


    public void saveNewUser(UserDTO userDTO) throws IncorrectDataException {
        //TODO remove BCrypt from constr
        User user = new User(userDTO.getEmail(),
                new BCryptPasswordEncoder().encode(userDTO.getPassword()),
                true,
                Collections.singleton(Role.USER));
       /* user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setActive(true);
        user.setAuthorities(Collections.singleton(Role.USER));*/
        try {
            userRepository.save(user);
            //return true;
        } catch (Exception e) {
            log.info("{this e-mail already exist}");
            setUserDTO(userDTO);
            throw new IncorrectDataException(userDTO);
            //e.printStackTrace();
        }
        //return false;
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

    public UserDTO getUserDTO() {
        return userDTO;
    }
}