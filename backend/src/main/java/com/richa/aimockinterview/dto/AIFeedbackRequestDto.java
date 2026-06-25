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
public class AIFeedbackRequestDto {

    private String question;

    private String expectedAnswer;

    private String userAnswer;
}
