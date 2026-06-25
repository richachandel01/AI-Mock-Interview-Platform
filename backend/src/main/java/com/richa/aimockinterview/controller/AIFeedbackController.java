package com.richa.aimockinterview.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.richa.aimockinterview.dto.AIFeedbackRequestDto;
import com.richa.aimockinterview.dto.AIFeedbackResponseDto;
import com.richa.aimockinterview.service.AIFeedbackService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/ai-feedback")
@RequiredArgsConstructor
public class AIFeedbackController {

    private final AIFeedbackService aiFeedbackService;

    @PostMapping
    public AIFeedbackResponseDto generateFeedback(
            @RequestBody AIFeedbackRequestDto request) {

        return aiFeedbackService.generateFeedback(request);
    }
}