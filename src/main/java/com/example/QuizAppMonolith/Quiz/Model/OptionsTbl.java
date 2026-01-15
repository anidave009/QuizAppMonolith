package com.example.QuizAppMonolith.Quiz.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="options")
public class OptionsTbl {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer optionId;

    @Column
    public Integer questionId;

    @Column
    public String optionText;

    @Column
    public Integer isCorrect;
}
