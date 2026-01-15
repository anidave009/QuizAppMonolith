package com.example.QuizAppMonolith.Quiz.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponseDto {
    public Integer quizId;
    public String quizName;
    public String category;
}
