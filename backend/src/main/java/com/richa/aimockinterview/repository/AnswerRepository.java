package com.richa.aimockinterview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.richa.aimockinterview.entity.Answer;
import com.richa.aimockinterview.entity.InterviewSession;

public interface AnswerRepository
        extends JpaRepository<Answer, Long> {

    List<Answer> findByInterviewSession(
            InterviewSession interviewSession);
}