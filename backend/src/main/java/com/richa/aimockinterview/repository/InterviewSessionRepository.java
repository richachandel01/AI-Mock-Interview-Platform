package com.richa.aimockinterview.repository;

import java.util.List;   

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.richa.aimockinterview.entity.InterviewSession;
import com.richa.aimockinterview.entity.User;

@Repository
public interface InterviewSessionRepository
        extends JpaRepository<InterviewSession, Long> {

    List<InterviewSession> findByUser(User user);

}