package com.richa.aimockinterview.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.richa.aimockinterview.dto.AnswerRequestDto;
import com.richa.aimockinterview.dto.AnswerResponseDto;
import com.richa.aimockinterview.entity.Answer;
import com.richa.aimockinterview.entity.InterviewSession;
import com.richa.aimockinterview.entity.Question;
import com.richa.aimockinterview.repository.AnswerRepository;
import com.richa.aimockinterview.repository.InterviewSessionRepository;
import com.richa.aimockinterview.repository.QuestionRepository;
import com.richa.aimockinterview.service.AnswerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl
        implements AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final InterviewSessionRepository interviewSessionRepository;

    @Override
    public AnswerResponseDto submitAnswer(
            AnswerRequestDto request) {

        Question question =
                questionRepository.findById(
                        request.getQuestionId())
                        .orElseThrow();

        InterviewSession session =
                interviewSessionRepository.findById(
                        request.getSessionId())
                        .orElseThrow();

        Answer answer =
                Answer.builder()
                        .userAnswer(request.getUserAnswer())
                        .submittedAt(LocalDateTime.now())
                        .question(question)
                        .interviewSession(session)
                        .build();

        Answer savedAnswer =
                answerRepository.save(answer);

        return AnswerResponseDto.builder()
                .id(savedAnswer.getId())
                .userAnswer(savedAnswer.getUserAnswer())
                .submittedAt(savedAnswer.getSubmittedAt())
                .build();
    }

    @Override
    public List<AnswerResponseDto> getAllAnswers() {

        return answerRepository.findAll()
                .stream()
                .map(answer ->
                        AnswerResponseDto.builder()
                                .id(answer.getId())
                                .userAnswer(answer.getUserAnswer())
                                .submittedAt(answer.getSubmittedAt())
                                .build())
                .toList();
    }
}