package com.example.BackendBeginner.domain;

import com.example.BackendBeginner.controller.dto.UserRequestDTO;

import java.util.*;

public interface UserRepository {
    User save(UserRequestDTO user);
    Optional<User> findById(Long id);
    Optional<User> findByName(String username);
    List<User> findAll();
}
