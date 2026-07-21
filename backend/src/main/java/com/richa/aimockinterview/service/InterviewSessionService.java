package com.richa.aimockinterview.service;

import java.util.List;

import com.richa.aimockinterview.dto.InterviewHistoryResponseDto;
import com.richa.aimockinterview.dto.InterviewSessionRequestDto;
import com.richa.aimockinterview.dto.InterviewSessionResponseDto;

public interface InterviewSessionService {

    InterviewSessionResponseDto startSession(
            InterviewSessionRequestDto request);
    
            List<InterviewHistoryResponseDto> getInterviewHistory();
    List<InterviewSessionResponseDto> getAllSessions();
}