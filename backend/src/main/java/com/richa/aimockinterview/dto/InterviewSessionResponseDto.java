package com.richa.aimockinterview.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InterviewSessionResponseDto {

    private Long id;

    private String status;

    private Integer score;

    private LocalDateTime startedAt;

    private LocalDateTime completedAt;
}