package com.example.BackendBeginner.domain;

import lombok.Getter;

@Getter
// @NoArgsConstructor(access = AccessLevel.PROTECTED) 사용 시 기본 생성자 자동 생성
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
