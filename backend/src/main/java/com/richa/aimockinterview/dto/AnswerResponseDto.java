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
public class AnswerResponseDto {

    private Long id;

private String userAnswer;

private LocalDateTime submittedAt;

private Long questionId;

private String questionText;

private Integer score;

private String feedback;
}