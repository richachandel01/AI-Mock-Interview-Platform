package com.richa.aimockinterview.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InterviewRequestDto {

    private String title;
    private String domain;
    private String level;
}
