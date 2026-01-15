    package com.example.QuizAppMonolith.Attempt.Model;

    import jakarta.persistence.*;
    import lombok.Data;

    import java.time.LocalDateTime;

    @Entity
    @Table(name="attempts")
    @Data
    public class AttemptTbl {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer attemptId;

        @Column
        private Integer userId;

        @Column
        private Integer quizId;

        @Column
        private Integer score;

        @Column
        private String quizName;

        @Column
        private LocalDateTime attemptTime;
    }
