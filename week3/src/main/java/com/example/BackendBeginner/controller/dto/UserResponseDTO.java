package com.example.BackendBeginner.controller.dto;

import lombok.Getter;

@Getter
public class UserResponseDTO {

    private final Long id;
    private final String username;
    private final int age;

    public UserResponseDTO(Long id, String username, int age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }
}
