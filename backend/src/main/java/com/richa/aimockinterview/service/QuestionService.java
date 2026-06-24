package com.richa.aimockinterview.service;

import java.util.List;

import com.richa.aimockinterview.dto.QuestionRequestDto;
import com.richa.aimockinterview.dto.QuestionResponseDto;

public interface QuestionService {

    QuestionResponseDto createQuestion(
            QuestionRequestDto request);

    List<QuestionResponseDto> getAllQuestions();
}