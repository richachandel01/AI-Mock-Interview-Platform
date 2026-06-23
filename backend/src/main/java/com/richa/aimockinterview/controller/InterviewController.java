package com.richa.aimockinterview.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.richa.aimockinterview.dto.InterviewRequestDto;
import com.richa.aimockinterview.dto.InterviewResponseDto;
import com.richa.aimockinterview.service.InterviewService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/interviews")
@RequiredArgsConstructor
public class InterviewController {

    private final InterviewService interviewService;

    @PostMapping
    public InterviewResponseDto createInterview(
            @RequestBody InterviewRequestDto request) {

        return interviewService.createInterview(request);
    }

    @GetMapping
    public List<InterviewResponseDto> getAllInterviews() {

        return interviewService.getAllInterviews();
    }
}