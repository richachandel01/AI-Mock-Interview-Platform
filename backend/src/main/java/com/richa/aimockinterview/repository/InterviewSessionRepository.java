package com.richa.aimockinterview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.richa.aimockinterview.entity.InterviewSession;

@Repository
public interface InterviewSessionRepository
        extends JpaRepository<InterviewSession, Long> {
}