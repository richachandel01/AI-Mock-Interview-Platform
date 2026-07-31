package com.richa.aimockinterview.controller;

import org.springframework.web.bind.annotation.*;

import com.richa.aimockinterview.dto.LoginRequestDto;
import com.richa.aimockinterview.dto.LoginResponseDto;
import com.richa.aimockinterview.dto.RegisterRequestDto;
import com.richa.aimockinterview.dto.RegisterResponseDto;
import com.richa.aimockinterview.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public RegisterResponseDto register(
            @RequestBody RegisterRequestDto request) {

        return authService.register(request);
    }

    @PostMapping("/login")
    public LoginResponseDto login(
            @RequestBody LoginRequestDto request) {

        return authService.login(request);
    }
}