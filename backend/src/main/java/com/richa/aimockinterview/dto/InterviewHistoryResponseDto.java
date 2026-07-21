package com.richa.aimockinterview.dto;

import java.time.LocalDateTime;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InterviewHistoryResponseDto {

    private Long sessionId;

    private String role;

    private Integer totalQuestions;

    private Integer score;

    private String status;

    private LocalDateTime createdAt;

}