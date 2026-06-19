package com.richa.aimockinterview.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.richa.aimockinterview.dto.UserRequestDto;
import com.richa.aimockinterview.dto.UserResponseDto;
import com.richa.aimockinterview.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserResponseDto createUser(
            @RequestBody UserRequestDto request) {

        return userService.createUser(request);
    }
}