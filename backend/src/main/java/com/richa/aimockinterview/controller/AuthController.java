package com.richa.aimockinterview.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.richa.aimockinterview.dto.LoginRequestDto;
import com.richa.aimockinterview.dto.LoginResponseDto;
import com.richa.aimockinterview.security.jwt.JwtService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtService jwtService;

    @PostMapping("/login")
    public LoginResponseDto login(
            @RequestBody LoginRequestDto request) {

        String token =
                jwtService.generateToken(
                        request.getEmail());

        return LoginResponseDto.builder()
                .token(token)
                .build();
    }
}