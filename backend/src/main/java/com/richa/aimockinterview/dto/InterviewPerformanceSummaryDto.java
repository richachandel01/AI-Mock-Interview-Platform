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
public class InterviewPerformanceSummaryDto {

    private Integer totalQuestions;

    private Integer answeredQuestions;

    private Integer averageScore;

    private Integer performancePercentage;
}