package com.richa.aimockinterview.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.richa.aimockinterview.dto.AnswerRequestDto;
import com.richa.aimockinterview.dto.AnswerResponseDto;
import com.richa.aimockinterview.service.AnswerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/answers")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;

    @PostMapping
    public AnswerResponseDto submitAnswer(
            @RequestBody AnswerRequestDto request) {

        return answerService.submitAnswer(request);
    }

    @GetMapping
    public List<AnswerResponseDto> getAllAnswers() {

        return answerService.getAllAnswers();
    }
}