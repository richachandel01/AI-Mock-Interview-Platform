package com.richa.aimockinterview.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequestDto {

    private String name;

    private String email;

    private String password;
}