package com.richa.aimockinterview.service.impl;

import org.springframework.stereotype.Service;

import com.richa.aimockinterview.dto.DashboardSummaryDto;
import com.richa.aimockinterview.repository.AnswerRepository;
import com.richa.aimockinterview.repository.EvaluationResultRepository;
import com.richa.aimockinterview.repository.InterviewSessionRepository;
import com.richa.aimockinterview.service.DashboardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    private final InterviewSessionRepository interviewSessionRepository;
    private final AnswerRepository answerRepository;
    private final EvaluationResultRepository evaluationResultRepository;

    @Override
    public DashboardSummaryDto getDashboardSummary() {

        return DashboardSummaryDto.builder()
                .totalInterviews(interviewSessionRepository.count())
                .totalAnswers(answerRepository.count())
                .averageScore(evaluationResultRepository.getAverageScore())
                .highestScore(evaluationResultRepository.getHighestScore())
                .build();
    }
}