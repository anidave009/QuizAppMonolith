package com.example.QuizAppMonolith.Attempt.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttemptResponse {
public Integer attemptId;
public Integer score;
public String quizName;
}
