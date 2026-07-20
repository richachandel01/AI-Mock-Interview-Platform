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
public class DashboardSummaryDto {

    private Long totalInterviews;

    private Long totalAnswers;

    private Double averageScore;

    private Integer highestScore;
}