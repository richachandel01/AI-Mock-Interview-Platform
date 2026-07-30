package com.richa.aimockinterview.dto;

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
public class AIFeedbackResponseDto {

    private Integer score;

private String feedback;

private String strengths;

private String weaknesses;

private String suggestions;
}