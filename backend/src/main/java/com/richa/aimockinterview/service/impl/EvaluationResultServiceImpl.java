package com.richa.aimockinterview.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.richa.aimockinterview.dto.EvaluationRequestDto;
import com.richa.aimockinterview.dto.EvaluationResponseDto;
import com.richa.aimockinterview.entity.Answer;
import com.richa.aimockinterview.entity.EvaluationResult;
import com.richa.aimockinterview.repository.AnswerRepository;
import com.richa.aimockinterview.repository.EvaluationResultRepository;
import com.richa.aimockinterview.service.EvaluationResultService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EvaluationResultServiceImpl
        implements EvaluationResultService {

    private final EvaluationResultRepository evaluationResultRepository;
    private final AnswerRepository answerRepository;

    @Override
    public EvaluationResponseDto evaluateAnswer(
            EvaluationRequestDto request) {

        Answer answer = answerRepository.findById(
                request.getAnswerId())
                .orElseThrow();

        int score;
        String feedback;

        int length = answer.getUserAnswer().length();

        if (length < 20) {
            score = 40;
            feedback = "Answer is too short.";
        } else if (length < 50) {
            score = 70;
            feedback = "Good answer but needs more detail.";
        } else {
            score = 90;
            feedback = "Excellent answer.";
        }

        EvaluationResult result =
                EvaluationResult.builder()
                        .score(score)
                        .feedback(feedback)
                        .answer(answer)
                        .build();

        EvaluationResult savedResult =
                evaluationResultRepository.save(result);

        return EvaluationResponseDto.builder()
                .id(savedResult.getId())
                .score(savedResult.getScore())
                .feedback(savedResult.getFeedback())
                .build();
    }

    @Override
    public List<EvaluationResponseDto> getAllResults() {

        return evaluationResultRepository.findAll()
                .stream()
                .map(result ->
                        EvaluationResponseDto.builder()
                                .id(result.getId())
                                .score(result.getScore())
                                .feedback(result.getFeedback())
                                .build())
                .toList();
    }
}