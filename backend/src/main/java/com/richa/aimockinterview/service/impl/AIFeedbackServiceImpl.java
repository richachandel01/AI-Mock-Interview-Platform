package com.richa.aimockinterview.service.impl;

import org.springframework.stereotype.Service;

import com.richa.aimockinterview.dto.AIFeedbackRequestDto;
import com.richa.aimockinterview.dto.AIFeedbackResponseDto;
import com.richa.aimockinterview.service.AIFeedbackService;

@Service
public class AIFeedbackServiceImpl implements AIFeedbackService {

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