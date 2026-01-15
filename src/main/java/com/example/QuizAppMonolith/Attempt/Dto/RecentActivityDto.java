package com.example.QuizAppMonolith.Attempt.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecentActivityDto {
public String quizName;
public Integer quizId;
public Integer score;
}
