package com.richa.aimockinterview.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.richa.aimockinterview.dto.QuestionRequestDto;
import com.richa.aimockinterview.dto.QuestionResponseDto;
import com.richa.aimockinterview.entity.Question;
import com.richa.aimockinterview.repository.QuestionRepository;
import com.richa.aimockinterview.service.QuestionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl
        implements QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public QuestionResponseDto createQuestion(
            QuestionRequestDto request) {

        Question question = Question.builder()
                .questionText(request.getQuestionText())
                .answer(request.getAnswer())
                .difficulty(request.getDifficulty())
                .technology(request.getTechnology())
                .build();

        Question savedQuestion =
                questionRepository.save(question);

        return QuestionResponseDto.builder()
                .id(savedQuestion.getId())
                .questionText(savedQuestion.getQuestionText())
                .answer(savedQuestion.getAnswer())
                .difficulty(savedQuestion.getDifficulty())
                .technology(savedQuestion.getTechnology())
                .build();
    }

    @Override
    public List<QuestionResponseDto> getAllQuestions() {

        return questionRepository.findAll()
                .stream()
                .map(question ->
                        QuestionResponseDto.builder()
                                .id(question.getId())
                                .questionText(question.getQuestionText())
                                .answer(question.getAnswer())
                                .difficulty(question.getDifficulty())
                                .technology(question.getTechnology())
                                .build())
                .toList();
    }
}