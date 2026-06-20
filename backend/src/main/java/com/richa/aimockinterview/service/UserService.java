package com.richa.aimockinterview.service;

import java.util.List;

import com.richa.aimockinterview.dto.UserRequestDto;
import com.richa.aimockinterview.dto.UserResponseDto;

public interface UserService {

    UserResponseDto createUser(UserRequestDto request);

    List<UserResponseDto> getAllUsers();
}