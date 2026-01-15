package com.example.QuizAppMonolith.Quiz.Service;

import com.example.QuizAppMonolith.Quiz.Dto.CategoryResponseDto;
import com.example.QuizAppMonolith.Quiz.Dto.OptionsDto;
import com.example.QuizAppMonolith.Quiz.Dto.QuestionIdDto;
import com.example.QuizAppMonolith.Quiz.Model.OptionsTbl;
import com.example.QuizAppMonolith.Quiz.Model.QuestionTbl;
import com.example.QuizAppMonolith.Quiz.Model.QuizCategoryTbl;
import com.example.QuizAppMonolith.Quiz.Repository.QuizOptionRepository;
import com.example.QuizAppMonolith.Quiz.Repository.QuizQuestionRepository;
import com.example.QuizAppMonolith.Quiz.Repository.QuizTblRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class QuizQuestionService {
    QuizTblRepository quizTblRepository;
    QuizQuestionRepository quizQuestionRepository;
    QuizOptionRepository quizOptionRepository;

public List<CategoryResponseDto> getAllQuizCategory(){
List<QuizCategoryTbl> quizCategoryList=quizTblRepository.findAll();
log.info("response received, retrieved records, call from repo succesful");
    List<CategoryResponseDto> listQuizCategoryResponse = new ArrayList<>();

for(QuizCategoryTbl quizCategoryTbl:quizCategoryList){
    CategoryResponseDto quizCategoryResponse = new CategoryResponseDto();
    quizCategoryResponse.setQuizId(quizCategoryTbl.getQuizId());
    quizCategoryResponse.setQuizName(quizCategoryTbl.getQuizName());
    quizCategoryResponse.setCategory(quizCategoryTbl.getCategory());
    listQuizCategoryResponse.add(quizCategoryResponse);
}
    log.info("Response received and now sending to svc->controller");
return listQuizCategoryResponse;
}

public List<QuestionIdDto> getAllQuestionIdsForCategory(Integer quizId){
    List<QuestionTbl> questionEntities=quizQuestionRepository.findByQuizId(quizId);
    List<QuestionIdDto> questionDTOs = questionEntities.stream()
            .map(entity -> new QuestionIdDto(
                    entity.getQuestionId(),
                    entity.getQuestionText()
            ))
            .collect(Collectors.toList());

    log.info("fetched questionIds",questionDTOs);
    return questionDTOs;
}

//here i will implement logic to map optiontblentity to optionsdtos
public List<OptionsDto> getOptionsForQuestionId(Integer questionId){
    List<OptionsTbl> optionEntities=quizOptionRepository.findByQuestionId(questionId);
    List<OptionsDto> optionsDtos=optionEntities.stream()
            .map(entity->new OptionsDto(
                  entity.getOptionText(),
                  entity.getIsCorrect()
            ))
            .collect((Collectors.toList()));
    log.info("Fetched Options dto and returning a list , it looks like" +
            " [{optionText:'4',isCorrect:'1'},{}]");
    return  optionsDtos;
}
}
