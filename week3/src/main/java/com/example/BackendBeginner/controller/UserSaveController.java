package com.example.BackendBeginner.controller;

import com.example.BackendBeginner.domain.User;
import com.example.BackendBeginner.domain.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserSaveController{

    private final UserRepository userRepository;

    public UserSaveController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/save")
    public String save(@RequestParam("username") String username,
                     @RequestParam("age") int age
                     ){
        User user = new User();
        user.setUsername(username);
        user.setAge(age);

        userRepository.save(user);
        return "ok";
    }
}
