package com.example.QuizAppMonolith.Quiz.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="questions")
public class QuestionTbl {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer questionId;

    @Column
    private String questionText;

    @Column
    private Integer quizId;

}
