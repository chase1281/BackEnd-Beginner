package com.example.BackendBeginner.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {
    private String username;
    private Long userId;
    private int age;

    public User(){

    }

    public User(int age, String username) {
        this.age = age;
        this.username = username;
    }
}
