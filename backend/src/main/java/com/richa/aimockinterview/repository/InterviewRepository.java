package com.richa.aimockinterview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.richa.aimockinterview.entity.Interview;
import com.richa.aimockinterview.entity.User;

public interface InterviewRepository
        extends JpaRepository<Interview, Long> {

    List<Interview> findByUser(User user);
}