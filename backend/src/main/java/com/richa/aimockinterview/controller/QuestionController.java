package com.richa.aimockinterview.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.richa.aimockinterview.dto.QuestionRequestDto;
import com.richa.aimockinterview.dto.QuestionResponseDto;
import com.richa.aimockinterview.service.QuestionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping
    public QuestionResponseDto createQuestion(
            @RequestBody QuestionRequestDto request) {

        return questionService.createQuestion(request);
    }

    @GetMapping
    public List<QuestionResponseDto> getAllQuestions() {

        return questionService.getAllQuestions();
    }
}