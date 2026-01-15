package com.example.QuizAppMonolith.Quiz.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponseByIdDto {
    public Integer questionId;
    public String questionText;
    public List<OptionsDto> optionsDto;
}
