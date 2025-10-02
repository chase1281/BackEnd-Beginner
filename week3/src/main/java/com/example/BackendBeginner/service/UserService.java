package com.example.BackendBeginner.service;

import com.example.BackendBeginner.controller.dto.UserRequestDTO;
import com.example.BackendBeginner.controller.dto.UserResponseDTO;
import com.example.BackendBeginner.domain.User;
import com.example.BackendBeginner.domain.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO createUser(UserRequestDTO dto) {
        User savedUser = userRepository.save(dto);
        return new UserResponseDTO(savedUser.getUserId(), savedUser.getUsername(), savedUser.getAge());
    }  
    
    public UserResponseDTO getUser(Long userId) {
        User found = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("사용자 없음")); //@RestControllerAdvice로 예외처리 해주기
        return new UserResponseDTO(found.getUserId(), found.getUsername(), found.getAge());
    }  
    
    public List<UserResponseDTO> getAllUser() {
        return userRepository.findAll().stream()
                .map(user -> new UserResponseDTO(user.getUserId(), user.getUsername(), user.getAge())).toList();
    }

    public UserResponseDTO updateUser(Long userId, UserRequestDTO dto) {
        User found = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("사용자 없음"));
        found.update(dto.username(), dto.age());
        return new UserResponseDTO(found.getUserId(), found.getUsername(), found.getAge());
    }
}
