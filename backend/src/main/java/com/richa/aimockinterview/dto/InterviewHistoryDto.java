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
public class InterviewHistoryDto {

    private Long sessionId;

    private String interviewTitle;

    private String status;

    private LocalDateTime startedAt;

    private LocalDateTime completedAt;

    private Integer totalQuestions;

    private Integer answeredQuestions;

    private Integer averageScore;

    private Integer performancePercentage;
}