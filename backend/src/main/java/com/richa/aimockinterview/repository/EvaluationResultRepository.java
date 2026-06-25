package com.richa.aimockinterview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.richa.aimockinterview.entity.EvaluationResult;

@Repository
public interface EvaluationResultRepository
        extends JpaRepository<EvaluationResult, Long> {
}