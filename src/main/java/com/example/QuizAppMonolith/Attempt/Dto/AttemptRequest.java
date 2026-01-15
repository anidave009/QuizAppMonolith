package com.example.QuizAppMonolith.Attempt.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AttemptRequest {
    public Integer userId;
    public Integer quizId;
    public Integer score;
    public String quizName;
}
