package com.example.BackendBeginner.controller;

import com.example.BackendBeginner.controller.dto.UserResponseDTO;
import com.example.BackendBeginner.domain.User;
import com.example.BackendBeginner.domain.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserListController{

    private final UserRepository userRepository;

    public UserListController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<UserResponseDTO> users(){
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> new UserResponseDTO(user.getUserId(), user.getUsername(), user.getAge())).toList();
    }

    @GetMapping("/{userId}")
    public UserResponseDTO user(@PathVariable("userId") Long userId){
        User findUser = userRepository.findById(userId);
        return new UserResponseDTO(findUser.getUserId(), findUser.getUsername(), findUser.getAge());
    }
}
