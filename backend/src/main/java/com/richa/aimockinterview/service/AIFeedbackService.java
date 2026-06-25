package com.richa.aimockinterview.service;

import com.richa.aimockinterview.dto.AIFeedbackRequestDto;
import com.richa.aimockinterview.dto.AIFeedbackResponseDto;

public interface AIFeedbackService {

    AIFeedbackResponseDto generateFeedback(
            AIFeedbackRequestDto request);
}