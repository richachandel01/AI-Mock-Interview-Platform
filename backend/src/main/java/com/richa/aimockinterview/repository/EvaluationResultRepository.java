package com.richa.aimockinterview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.richa.aimockinterview.entity.EvaluationResult;

@Repository
public interface EvaluationResultRepository
        extends JpaRepository<EvaluationResult, Long> {

    @Query("SELECT AVG(e.score) FROM EvaluationResult e")
    Double getAverageScore();

    @Query("SELECT MAX(e.score) FROM EvaluationResult e")
    Integer getHighestScore();
}