package com.richa.aimockinterview.service;

import com.richa.aimockinterview.dto.AIFeedbackResponseDto;

public interface AIFeedbackService {

    AIFeedbackResponseDto evaluateAnswer(Long answerId);

}