package com.richa.aimockinterview.service;

import com.richa.aimockinterview.dto.UserRequestDto;
import com.richa.aimockinterview.dto.UserResponseDto;

public interface UserService {

    UserResponseDto createUser(UserRequestDto request);
}