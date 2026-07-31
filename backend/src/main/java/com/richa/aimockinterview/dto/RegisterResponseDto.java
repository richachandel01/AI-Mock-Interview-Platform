package com.richa.aimockinterview.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterResponseDto {

    private Long id;

    private String name;

    private String email;

    private String message;
}