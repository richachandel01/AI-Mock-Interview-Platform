package com.richa.aimockinterview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.richa.aimockinterview.entity.Question;

@Repository
public interface QuestionRepository
        extends JpaRepository<Question, Long> {

}