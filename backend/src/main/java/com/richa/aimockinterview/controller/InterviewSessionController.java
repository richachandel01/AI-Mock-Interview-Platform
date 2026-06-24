package com.richa.aimockinterview.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.richa.aimockinterview.dto.InterviewSessionRequestDto;
import com.richa.aimockinterview.dto.InterviewSessionResponseDto;
import com.richa.aimockinterview.service.InterviewSessionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/sessions")
@RequiredArgsConstructor
public class InterviewSessionController {

    private final InterviewSessionService interviewSessionService;

    @PostMapping
    public InterviewSessionResponseDto createSession(
            @RequestBody InterviewSessionRequestDto request) {

return interviewSessionService.startSession(request);    }

    @GetMapping
    public List<InterviewSessionResponseDto> getAllSessions() {

        return interviewSessionService.getAllSessions();
    }
}