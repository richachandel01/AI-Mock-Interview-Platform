package com.richa.aimockinterview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.richa.aimockinterview.entity.Interview;
import com.richa.aimockinterview.entity.Question;

public interface QuestionRepository
        extends JpaRepository<Question, Long> {

    List<Question> findByInterview(Interview interview);
}