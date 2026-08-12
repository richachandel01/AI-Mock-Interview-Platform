package com.richa.aimockinterview.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.richa.aimockinterview.dto.QuestionRequestDto;
import com.richa.aimockinterview.dto.QuestionResponseDto;
import com.richa.aimockinterview.entity.Interview;
import com.richa.aimockinterview.entity.Question;
import com.richa.aimockinterview.repository.InterviewRepository;
import com.richa.aimockinterview.repository.QuestionRepository;
import com.richa.aimockinterview.service.QuestionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final InterviewRepository interviewRepository;

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

        return mapToResponse(savedQuestion);
    }

    @Override
    public List<QuestionResponseDto> getAllQuestions() {

        return questionRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public List<QuestionResponseDto> getQuestionsByInterview(
            Long interviewId) {

        Interview interview = interviewRepository.findById(interviewId)
                .orElseThrow(() ->
                        new RuntimeException("Interview not found"));

        return questionRepository
                .findByInterview(interview)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private QuestionResponseDto mapToResponse(
            Question question) {

        return QuestionResponseDto.builder()
                .id(question.getId())
                .questionText(question.getQuestionText())
                .answer(question.getAnswer())
                .difficulty(question.getDifficulty())
                .technology(question.getTechnology())
                .build();
    }
}