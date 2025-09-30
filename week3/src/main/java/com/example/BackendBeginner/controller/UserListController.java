package com.example.BackendBeginner.controller;

import com.example.BackendBeginner.controller.dto.UserResponseDTO;
import com.example.BackendBeginner.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserListController{

    private final UserService userService;

    public UserListController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponseDTO> users(){
        return userService.getAllUser();
    }

    @GetMapping("/{userId}")
    public UserResponseDTO user(@PathVariable("userId") Long userId){
        return userService.getUser(userId);
    }
}
