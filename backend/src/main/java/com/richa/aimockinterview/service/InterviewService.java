package com.richa.aimockinterview.service;

import java.util.List;

import com.richa.aimockinterview.dto.InterviewRequestDto;
import com.richa.aimockinterview.dto.InterviewResponseDto;

public interface InterviewService {

    InterviewResponseDto createInterview(
            InterviewRequestDto request);

    List<InterviewResponseDto> getAllInterviews();
}