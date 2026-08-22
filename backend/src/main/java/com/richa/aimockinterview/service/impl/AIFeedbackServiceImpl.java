package com.richa.aimockinterview.service.impl;

import org.springframework.stereotype.Service;

import com.richa.aimockinterview.ai.AIProvider;
import com.richa.aimockinterview.dto.AIFeedbackRequestDto;
import com.richa.aimockinterview.dto.AIFeedbackResponseDto;
import com.richa.aimockinterview.entity.Answer;
import com.richa.aimockinterview.entity.Question;
import com.richa.aimockinterview.repository.AnswerRepository;
import com.richa.aimockinterview.service.AIFeedbackService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AIFeedbackServiceImpl implements AIFeedbackService {

    private final AnswerRepository answerRepository;
    private final AIProvider aiProvider;

    @Override
    public AIFeedbackResponseDto evaluateAnswer(Long answerId) {

        Answer answer = answerRepository.findById(answerId)
                .orElseThrow(() -> new RuntimeException("Answer not found"));

        Question question = answer.getQuestion();

        if (question == null) {
            throw new RuntimeException("Question not found for answer");
        }

        AIFeedbackRequestDto request = AIFeedbackRequestDto.builder()
                .question(question.getQuestionText())
                .expectedAnswer(question.getAnswer())
                .userAnswer(answer.getUserAnswer())
                .build();

        AIFeedbackResponseDto response =
                aiProvider.generateFeedback(request);

        answer.setScore(response.getScore());
        answer.setFeedback(response.getFeedback());

        answerRepository.save(answer);

        return response;
    }
}