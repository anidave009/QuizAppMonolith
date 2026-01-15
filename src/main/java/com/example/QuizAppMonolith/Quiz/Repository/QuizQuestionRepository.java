package com.example.QuizAppMonolith.Quiz.Repository;

import com.example.QuizAppMonolith.Quiz.Model.QuestionTbl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizQuestionRepository extends JpaRepository<QuestionTbl,Integer> {
    List<QuestionTbl> findByQuizId(Integer quizId);
}
