package com.richa.aimockinterview.ai;

import com.richa.aimockinterview.dto.AIFeedbackRequestDto;
import com.richa.aimockinterview.dto.AIFeedbackResponseDto;

public interface AIProvider {

    AIFeedbackResponseDto generateFeedback(
            AIFeedbackRequestDto request);
}