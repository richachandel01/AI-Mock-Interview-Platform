package com.richa.aimockinterview.service.impl;

import org.springframework.stereotype.Service;

import com.richa.aimockinterview.ai.AIProvider;
import com.richa.aimockinterview.dto.AIFeedbackRequestDto;
import com.richa.aimockinterview.dto.AIFeedbackResponseDto;
import com.richa.aimockinterview.service.AIFeedbackService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AIFeedbackServiceImpl implements AIFeedbackService {

    private final AIProvider aiProvider;

    @Override
    public AIFeedbackResponseDto generateFeedback(
            AIFeedbackRequestDto request) {

        return aiProvider.generateFeedback(request);
    }
}