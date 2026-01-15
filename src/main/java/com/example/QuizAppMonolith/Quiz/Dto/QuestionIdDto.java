package com.example.QuizAppMonolith.Quiz.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionIdDto {
    public Integer questionId;
    public String questionText;
}
