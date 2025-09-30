package com.example.BackendBeginner.controller;

import com.example.BackendBeginner.controller.dto.UserRequestDTO;
import com.example.BackendBeginner.controller.dto.UserResponseDTO;
import com.example.BackendBeginner.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserEditController{

    private final UserService userService;

    public UserEditController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/{userId}/edit")
    public UserResponseDTO editForm(@PathVariable("userId") Long userId, @RequestBody UserRequestDTO dto){
        return userService.updateUser(userId, dto);
    }
}