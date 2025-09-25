package com.example.BackendBeginner.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
    private Map<Long, User> users = new HashMap<>();
    private static long sequence = 0L;

    //@Repository가 자동으로 싱글톤 패턴을 구현해줌.
/*    private static final UserRepository  instance = new UserRepository();

    public static UserRepository getInstance(){
        return instance;
    }*/

    public User save(User user){
        user.setUserId(++sequence); // ++sequence는 자바 계산 상 오류가 발생할 수 있어 권장하지 않고, sequence += 1로 하는게 낫다. 증감연산자가 문제
        users.put(user.getUserId(), user);
        return user;
    }

    public User findById(Long id){
        return users.get(id);
    }

    public List<User> findAll(){
        return new ArrayList<>(users.values());
    }

    public void update(Long userId, User updateParam){
        User findUser = findById(userId);
        findUser.setUsername(updateParam.getUsername());
        findUser.setAge(updateParam.getAge());
    }

}
