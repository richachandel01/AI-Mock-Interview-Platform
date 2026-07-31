package com.richa.aimockinterview.service.impl;

import org.springframework.stereotype.Service;

import com.richa.aimockinterview.dto.LoginRequestDto;
import com.richa.aimockinterview.dto.LoginResponseDto;
import com.richa.aimockinterview.dto.RegisterRequestDto;
import com.richa.aimockinterview.dto.RegisterResponseDto;
import com.richa.aimockinterview.entity.User;
import com.richa.aimockinterview.repository.UserRepository;
import com.richa.aimockinterview.security.jwt.JwtService;
import com.richa.aimockinterview.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    @Override
    public RegisterResponseDto register(RegisterRequestDto request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        User savedUser = userRepository.save(user);

        return RegisterResponseDto.builder()
                .id(savedUser.getId())
                .name(savedUser.getName())
                .email(savedUser.getEmail())
                .message("Registration Successful")
                .build();
    }

    @Override
    public LoginResponseDto login(LoginRequestDto request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtService.generateToken(user.getEmail());

        return LoginResponseDto.builder()
                .token(token)
                .build();
    }
}