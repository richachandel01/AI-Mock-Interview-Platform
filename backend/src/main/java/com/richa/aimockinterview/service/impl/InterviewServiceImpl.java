package com.richa.aimockinterview.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.richa.aimockinterview.dto.InterviewRequestDto;
import com.richa.aimockinterview.dto.InterviewResponseDto;
import com.richa.aimockinterview.entity.Interview;
import com.richa.aimockinterview.repository.InterviewRepository;
import com.richa.aimockinterview.service.InterviewService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InterviewServiceImpl
        implements InterviewService {

    private final InterviewRepository interviewRepository;

    @Override
    public InterviewResponseDto createInterview(
            InterviewRequestDto request) {

        Interview interview = Interview.builder()
                .title(request.getTitle())
                .role(request.getRole())
                .technology(request.getTechnology())
                .difficulty(request.getDifficulty())
                .build();

        Interview savedInterview =
                interviewRepository.save(interview);

        return InterviewResponseDto.builder()
                .id(savedInterview.getId())
                .title(savedInterview.getTitle())
                .role(savedInterview.getRole())
.technology(savedInterview.getTechnology())
.difficulty(savedInterview.getDifficulty())
                .build();
    }

    @Override
    public List<InterviewResponseDto> getAllInterviews() {

        return interviewRepository.findAll()
                .stream()
                .map(interview ->
                        InterviewResponseDto.builder()
                                .id(interview.getId())
                                .title(interview.getTitle())
                                .role(interview.getRole())
.technology(interview.getTechnology())
.difficulty(interview.getDifficulty())
                                .build())
                .toList();
    }
}