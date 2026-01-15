package com.example.QuizAppMonolith.Quiz.Repository;

import com.example.QuizAppMonolith.Quiz.Model.QuizCategoryTbl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizTblRepository extends JpaRepository<QuizCategoryTbl,String> {
}
