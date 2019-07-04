package com.company.exceptions;

import com.company.dto.UserDTO;

public class IncorrectDataException extends Exception {
    private UserDTO userDTO;

    public IncorrectDataException(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }
}
