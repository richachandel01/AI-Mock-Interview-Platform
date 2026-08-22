package com.richa.aimockinterview.service.impl;

import org.springframework.stereotype.Service;

import com.richa.aimockinterview.dto.AIFeedbackResponseDto;
import com.richa.aimockinterview.entity.Answer;
import com.richa.aimockinterview.repository.AnswerRepository;
import com.richa.aimockinterview.service.AIFeedbackService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AIFeedbackServiceImpl implements AIFeedbackService {

    private final AnswerRepository answerRepository;

    @Override
    public AIFeedbackResponseDto evaluateAnswer(Long answerId) {

        Answer answer = answerRepository.findById(answerId)
                .orElseThrow();

        return AIFeedbackResponseDto.builder()
                .score(0.0)
                .feedback("AI evaluation pending.")
                .build();
    }
}