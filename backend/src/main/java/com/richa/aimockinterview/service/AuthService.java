package com.richa.aimockinterview.service;

import com.richa.aimockinterview.dto.LoginRequestDto;
import com.richa.aimockinterview.dto.LoginResponseDto;
import com.richa.aimockinterview.dto.RegisterRequestDto;
import com.richa.aimockinterview.dto.RegisterResponseDto;

public interface AuthService {

    RegisterResponseDto register(RegisterRequestDto request);

    LoginResponseDto login(LoginRequestDto request);

}