package com.example.BackendBeginner.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter //도메인을 쓸 때 Setter를 사용하면 안 좋다. 이유는? 다른 사람이 마음대로 바꿀 수 있기 때문.
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
    //도메인에서 update를 구현하면 내가 직접 검증할 수 있다.? 따로 메서드를 구현해서 바꿔라 Setter 대신.
}
