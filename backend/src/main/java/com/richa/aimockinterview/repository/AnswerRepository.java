package com.richa.aimockinterview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.richa.aimockinterview.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

    List<Answer> findByInterviewSessionId(Long sessionId);
}