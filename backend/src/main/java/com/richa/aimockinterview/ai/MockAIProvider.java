package com.richa.aimockinterview.ai;

import org.springframework.stereotype.Component;

import com.richa.aimockinterview.dto.AIFeedbackRequestDto;
import com.richa.aimockinterview.dto.AIFeedbackResponseDto;

@Component
public class MockAIProvider implements AIProvider {

    @Override
    public AIFeedbackResponseDto generateFeedback(
            AIFeedbackRequestDto request) {

        int score = 70;

        String feedback =
                "Good answer but needs more technical details.";

        if (request.getUserAnswer() != null
                && request.getUserAnswer().length() > 50) {

            score = 85;

            feedback =
                    "Well explained answer with decent detail.";
        }

        return AIFeedbackResponseDto.builder()
                .score(score)
                .feedback(feedback)
                .build();
    }
}