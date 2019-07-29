package com.company.controller;

import com.company.dto.ReceiptsDTO;
import com.company.dto.UserDTO;
import com.company.dto.UsersDTO;
import com.company.entity.Receipt;
import com.company.entity.User;
import com.company.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping(value = "/")
public class DataController {

    private final UserService userService;

    public DataController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get_users")
    public UsersDTO userList() {
        return userService.getAllUsers();
    }

    @GetMapping("/userDTO")
    public UserDTO user() {
        return userService.getUserDTO();
    }

    @GetMapping("/account/get_receipts")
    public ReceiptsDTO getReceipts(HttpSession session) {
        return (ReceiptsDTO) session.getAttribute("receipts");
    }

    @GetMapping("/account/users/{id}/receipts_history")
    public Set<Receipt> getUserReceiptsHistory(@PathVariable(name = "id") User user) {
        return user.getReceipts();
    }
}
