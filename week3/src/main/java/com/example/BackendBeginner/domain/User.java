package com.example.BackendBeginner.domain;

import lombok.Getter;

@Getter
public class User {
    private Long userId;
    private String username;
    private int age;

    protected User(){

    }

    public User(Long userId, String username, int age) {
        this.userId = userId;
        this.username = username;
        this.age = age;
    }

    public void update(String username, int age){
        this.username = username;
        this.age = age;
    }
}
