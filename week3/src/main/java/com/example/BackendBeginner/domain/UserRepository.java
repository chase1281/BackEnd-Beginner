package com.example.BackendBeginner.domain;

import com.example.BackendBeginner.controller.dto.UserRequestDTO;

import java.util.*;

//Factory 메서드 구조에 대해 알아보기.
public interface UserRepository {
    User save(UserRequestDTO user);
    Optional<User> findById(Long id);
    Optional<User> findByName(String username);
    List<User> findAll();
}
