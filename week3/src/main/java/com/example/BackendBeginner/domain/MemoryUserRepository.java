package com.example.BackendBeginner.domain;

import com.example.BackendBeginner.controller.dto.UserRequestDTO;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryUserRepository implements UserRepository{
    private Map<Long, User> users = new HashMap<>();
    private static long sequence = 0L;

    //@Repository가 자동으로 싱글톤 패턴을 구현해줌.
/*    private static final UserRepository  instance = new UserRepository();

    public static UserRepository getInstance(){
        return instance;
    }*/

    @Override
    public User save(UserRequestDTO dto) {
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
