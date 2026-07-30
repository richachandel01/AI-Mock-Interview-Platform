package com.richa.aimockinterview.ai;

import org.springframework.stereotype.Component;

import com.richa.aimockinterview.dto.AIFeedbackRequestDto;
import com.richa.aimockinterview.dto.AIFeedbackResponseDto;

@Component
public class MockAIProvider implements AIProvider {

    @Override
    public AIFeedbackResponseDto evaluate(
            AIFeedbackRequestDto request) {

        int score;
        String feedback;
        String strengths;
        String weaknesses;
        String suggestions;

        int length = request.getUserAnswer().length();

        if (length < 20) {

            score = 40;
            feedback = "Answer is too short.";
            strengths = "Basic understanding of the topic.";
            weaknesses = "Very little explanation.";
            suggestions = "Explain the concept with examples.";

        } else if (length < 50) {

            score = 70;
            feedback = "Good answer but needs more detail.";
            strengths = "Core concept is mostly correct.";
            weaknesses = "Missing technical depth.";
            suggestions = "Include examples and key points.";

        } else {

            score = 90;
            feedback = "Excellent answer.";
            strengths = "Well structured and technically correct.";
            weaknesses = "Minor improvements possible.";
            suggestions = "Keep the same clarity and confidence.";
        }

        return AIFeedbackResponseDto.builder()
                .score(score)
                .feedback(feedback)
                .strengths(strengths)
                .weaknesses(weaknesses)
                .suggestions(suggestions)
                .build();
    }
}