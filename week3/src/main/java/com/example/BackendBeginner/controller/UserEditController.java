package com.example.BackendBeginner.controller;

import com.example.BackendBeginner.domain.User;
import com.example.BackendBeginner.domain.UserRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserEditController{

    private final UserRepository userRepository;

    public UserEditController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{userId}/edit")
    public String editForm(@PathVariable("userId") Long userId, Model model){
        User user = userRepository.findById(userId);
        model.addAttribute("user", user);
        return "users/editForm";
    }

    @PostMapping("/{userId}/edit")
    public String edit(@PathVariable("userId") Long userId, @ModelAttribute User user){
        userRepository.update(userId, user);
        return "ok";
    }
}
