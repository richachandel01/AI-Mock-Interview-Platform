package com.richa.aimockinterview.service;

import java.util.List;

import com.richa.aimockinterview.dto.AnswerRequestDto;
import com.richa.aimockinterview.dto.AnswerResponseDto;

public interface AnswerService {

    AnswerResponseDto submitAnswer(
            AnswerRequestDto request);

    List<AnswerResponseDto> getAllAnswers();
}