package com.richa.aimockinterview.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.richa.aimockinterview.dto.InterviewSessionRequestDto;
import com.richa.aimockinterview.dto.InterviewSessionResponseDto;
import com.richa.aimockinterview.entity.Interview;
import com.richa.aimockinterview.entity.InterviewSession;
import com.richa.aimockinterview.entity.User;
import com.richa.aimockinterview.repository.InterviewRepository;
import com.richa.aimockinterview.repository.InterviewSessionRepository;
import com.richa.aimockinterview.repository.UserRepository;
import com.richa.aimockinterview.service.InterviewSessionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InterviewSessionServiceImpl
        implements InterviewSessionService {

    private final InterviewSessionRepository interviewSessionRepository;
    private final UserRepository userRepository;
    private final InterviewRepository interviewRepository;

    @Override
    public InterviewSessionResponseDto startSession(
            InterviewSessionRequestDto request) {

        User user = userRepository.findById(
                request.getUserId())
                .orElseThrow();

        Interview interview = interviewRepository.findById(
                request.getInterviewId())
                .orElseThrow();

        InterviewSession session =
                InterviewSession.builder()
                        .status("STARTED")
                        .score(0)
                        .startedAt(LocalDateTime.now())
                        .user(user)
                        .interview(interview)
                        .build();

        InterviewSession savedSession =
                interviewSessionRepository.save(session);

        return InterviewSessionResponseDto.builder()
                .id(savedSession.getId())
                .status(savedSession.getStatus())
                .score(savedSession.getScore())
                .startedAt(savedSession.getStartedAt())
                .completedAt(savedSession.getCompletedAt())
                .build();
    }

    @Override
    public List<InterviewSessionResponseDto> getAllSessions() {

        return interviewSessionRepository.findAll()
                .stream()
                .map(session ->
                        InterviewSessionResponseDto.builder()
                                .id(session.getId())
                                .status(session.getStatus())
                                .score(session.getScore())
                                .startedAt(session.getStartedAt())
                                .completedAt(session.getCompletedAt())
                                .build())
                .toList();
    }
}