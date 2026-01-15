package com.example.QuizAppMonolith.Attempt.Repository;

import com.example.QuizAppMonolith.Attempt.Model.AttemptTbl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttemptRepository extends JpaRepository<AttemptTbl,Integer> {
    @Query(value = """
    WITH ranked_attempts AS (
        SELECT attempt_id, user_id, quiz_id, score, attempt_time,quiz_name,
               ROW_NUMBER() OVER (PARTITION BY quiz_id ORDER BY attempt_time DESC) AS rn
        FROM attempts
        WHERE user_id = :userId
    )
    SELECT * FROM ranked_attempts WHERE rn = 1 ORDER BY attempt_time DESC LIMIT 2
    """, nativeQuery = true)
    List<AttemptTbl> findLastTwoUniqueAttempts(@Param("userId") Integer userId);

}
