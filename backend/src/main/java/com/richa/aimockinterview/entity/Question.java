package com.richa.aimockinterview.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "questions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String questionText;

    @Column(length = 2000)
    private String answer;

    private String difficulty;

    private String technology;

    @ManyToOne
    @JoinColumn(name = "interview_id")
    private Interview interview;
}