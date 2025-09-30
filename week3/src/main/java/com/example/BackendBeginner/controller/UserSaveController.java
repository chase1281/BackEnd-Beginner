package com.example.BackendBeginner.controller;

import com.example.BackendBeginner.controller.dto.UserRequestDTO;
import com.example.BackendBeginner.controller.dto.UserResponseDTO;
import com.example.BackendBeginner.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserSaveController{

    private final UserService userService;

    public UserSaveController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public UserResponseDTO save(@RequestBody UserRequestDTO dto){
        return userService.createUser(dto);
    }
}
