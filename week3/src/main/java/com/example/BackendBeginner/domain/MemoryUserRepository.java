package com.example.BackendBeginner.domain;

import com.example.BackendBeginner.controller.dto.UserRequestDTO;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
//구현체이므로 MemoryUserRepositoryImpl 이런식으로 네이밍 하기
public class MemoryUserRepository implements UserRepository{
    private Map<Long, User> users = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public User save(UserRequestDTO dto) {
        //@Id, @GeneratedValue 등 애노테이션으로 JPA가 자동으로 만들어주고 findById 같은 메서드도 다 포함되어 있다.
        sequence += 1;
        long id = sequence;
        User user = new User(id, dto.username(), dto.age());
        users.put(id, user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id){
        return Optional.ofNullable(users.get(id));
    }

    @Override
    public Optional<User> findByName(String username) {
        return users.values().stream()
                .filter(user -> user.getUsername().equals(username))
                .findAny();
    }

    @Override
    public List<User> findAll(){
        return new ArrayList<>(users.values());
    }
}
