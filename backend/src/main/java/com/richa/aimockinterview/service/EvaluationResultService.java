package com.richa.aimockinterview.service;

import java.util.List;

import com.richa.aimockinterview.dto.EvaluationRequestDto;
import com.richa.aimockinterview.dto.EvaluationResponseDto;

public interface EvaluationResultService {

    EvaluationResponseDto evaluateAnswer(
            EvaluationRequestDto request);

    List<EvaluationResponseDto> getAllResults();
}