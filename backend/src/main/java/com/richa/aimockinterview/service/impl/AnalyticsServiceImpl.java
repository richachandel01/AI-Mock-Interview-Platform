package com.richa.aimockinterview.service.impl;

import org.springframework.stereotype.Service;

import com.richa.aimockinterview.dto.AnalyticsResponseDto;
import com.richa.aimockinterview.entity.EvaluationResult;
import com.richa.aimockinterview.repository.EvaluationResultRepository;
import com.richa.aimockinterview.repository.InterviewSessionRepository;
import com.richa.aimockinterview.service.AnalyticsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnalyticsServiceImpl implements AnalyticsService {

    private final InterviewSessionRepository interviewSessionRepository;
    private final EvaluationResultRepository evaluationResultRepository;

    @Override
public AnalyticsResponseDto getAnalytics() {

    long totalSessions =
            interviewSessionRepository.count();

    long completedSessions =
            interviewSessionRepository.findAll()
                    .stream()
                    .filter(session ->
                            "COMPLETED".equalsIgnoreCase(session.getStatus()))
                    .count();

    double averageScore =
            evaluationResultRepository.findAll()
                    .stream()
                    .mapToInt(EvaluationResult::getScore)
                    .average()
                    .orElse(0.0);

    int highestScore =
            evaluationResultRepository.findAll()
                    .stream()
                    .mapToInt(EvaluationResult::getScore)
                    .max()
                    .orElse(0);

    double successRate =
            totalSessions == 0
                    ? 0.0
                    : (completedSessions * 100.0) / totalSessions;

    return AnalyticsResponseDto.builder()
            .totalInterviews(totalSessions)
            .completedInterviews(completedSessions)
            .averageScore((int) Math.round(averageScore))
            .highestScore(highestScore)
            .successRate(successRate)
            .build();
}
}