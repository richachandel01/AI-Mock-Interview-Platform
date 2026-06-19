package com.richa.aimockinterview.service.impl;

import org.springframework.stereotype.Service;

import com.richa.aimockinterview.dto.UserRequestDto;
import com.richa.aimockinterview.dto.UserResponseDto;
import com.richa.aimockinterview.entity.User;
import com.richa.aimockinterview.repository.UserRepository;
import com.richa.aimockinterview.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponseDto createUser(UserRequestDto request) {

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .role("USER")
                .build();

        User savedUser = userRepository.save(user);

        return UserResponseDto.builder()
                .id(savedUser.getId())
                .name(savedUser.getName())
                .email(savedUser.getEmail())
                .role(savedUser.getRole())
                .build();
    }
}