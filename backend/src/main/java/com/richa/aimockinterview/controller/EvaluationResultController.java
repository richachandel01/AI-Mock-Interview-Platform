package com.richa.aimockinterview.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.richa.aimockinterview.dto.EvaluationRequestDto;
import com.richa.aimockinterview.dto.EvaluationResponseDto;
import com.richa.aimockinterview.service.EvaluationResultService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/evaluations")
@RequiredArgsConstructor
public class EvaluationResultController {

    private final EvaluationResultService evaluationResultService;

    @PostMapping
    public EvaluationResponseDto evaluateAnswer(
            @RequestBody EvaluationRequestDto request) {

        return evaluationResultService.evaluateAnswer(request);
    }

    @GetMapping
    public List<EvaluationResponseDto> getAllResults() {

        return evaluationResultService.getAllResults();
    }
}