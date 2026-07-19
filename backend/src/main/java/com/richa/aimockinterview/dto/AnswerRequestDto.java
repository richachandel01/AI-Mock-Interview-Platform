package com.richa.aimockinterview.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class AnswerRequestDto {

    @NotBlank(message = "Answer cannot be empty")
    private String userAnswer;

    @NotNull(message = "Question Id is required")
    private Long questionId;

    @NotNull(message = "Session Id is required")
    private Long sessionId;
}