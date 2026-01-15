package com.example.QuizAppMonolith.Quiz.controller;

import com.example.QuizAppMonolith.Quiz.Dto.CategoryResponseByIdDto;
import com.example.QuizAppMonolith.Quiz.Dto.CategoryResponseDto;
import com.example.QuizAppMonolith.Quiz.Dto.OptionsDto;
import com.example.QuizAppMonolith.Quiz.Dto.QuestionIdDto;
import com.example.QuizAppMonolith.Quiz.Service.QuizQuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/quiz")
public class QuizQuestionController {
    @Autowired
    QuizQuestionService quizQuestionService;

    @GetMapping("/getAllQuizCategory")
    public ResponseEntity<List<CategoryResponseDto>> getAllQuizCategory() {
            List<CategoryResponseDto> response = quizQuestionService.getAllQuizCategory();
            log.info("Response: {}", response);
            return ResponseEntity.ok(response);
    }

    @GetMapping("/getQuizCategory/{quizId}")
    public ResponseEntity<List<CategoryResponseByIdDto>> getQuizCategoryQuestions(
            @PathVariable("quizId") Integer quizId) {

        log.info("id for quizcgry is {}", quizId);

        List<QuestionIdDto> questions = quizQuestionService.getAllQuestionIdsForCategory(quizId);
        log.info("questions received: {}", questions);

        List<CategoryResponseByIdDto> allQuestionsWithOptions = new ArrayList<>();

        for (QuestionIdDto question : questions) {
            List<OptionsDto> optionsDtos = quizQuestionService.getOptionsForQuestionId(question.getQuestionId());

            CategoryResponseByIdDto response = new CategoryResponseByIdDto();
            response.setQuestionId(question.getQuestionId());
            response.setQuestionText(question.getQuestionText());
            response.setOptionsDto(optionsDtos);

            allQuestionsWithOptions.add(response);
        }

        return ResponseEntity.ok(allQuestionsWithOptions);
    }


}
