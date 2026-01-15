package com.example.QuizAppMonolith.Quiz.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="quizzes")
public class QuizCategoryTbl {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer quizId;

@Column(nullable = false)
private String quizName;

@Column(nullable = false)
private String category;
}
