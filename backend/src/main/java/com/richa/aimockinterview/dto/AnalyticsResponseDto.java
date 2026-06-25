package com.richa.aimockinterview.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnalyticsResponseDto {

    private Long totalSessions;

    private Double averageScore;

    private Integer highestScore;

    private Long totalEvaluations;
}