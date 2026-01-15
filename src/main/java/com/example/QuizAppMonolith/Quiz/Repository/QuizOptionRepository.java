package com.example.QuizAppMonolith.Quiz.Repository;

import com.example.QuizAppMonolith.Quiz.Model.OptionsTbl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizOptionRepository extends JpaRepository<OptionsTbl,Integer> {
    List<OptionsTbl> findByQuestionId(Integer questionId);
}
