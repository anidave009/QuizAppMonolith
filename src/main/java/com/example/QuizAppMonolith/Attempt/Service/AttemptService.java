package com.example.QuizAppMonolith.Attempt.Service;

import com.example.QuizAppMonolith.Attempt.Dto.AttemptRequest;
import com.example.QuizAppMonolith.Attempt.Dto.AttemptResponse;
import com.example.QuizAppMonolith.Attempt.Dto.RecentActivityDto;
import com.example.QuizAppMonolith.Attempt.Model.AttemptTbl;
import com.example.QuizAppMonolith.Attempt.Repository.AttemptRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class AttemptService {
    private AttemptRepository attemptRepository;

    public AttemptResponse storeAttempt(AttemptRequest attemptRequest) {
        AttemptTbl attemptTblentity = new AttemptTbl();
        attemptTblentity.setUserId(attemptRequest.getUserId());
        attemptTblentity.setQuizId(attemptRequest.getQuizId());
        attemptTblentity.setScore(attemptRequest.getScore());
        attemptTblentity.setQuizName(attemptRequest.getQuizName());


        attemptTblentity.setAttemptTime(LocalDateTime.now());


        AttemptTbl savedAttempt = attemptRepository.save(attemptTblentity);
        log.info("saved in repository");

        AttemptResponse response = new AttemptResponse();
        response.setAttemptId(savedAttempt.getAttemptId());
        response.setScore(savedAttempt.getScore());
        response.setQuizName(savedAttempt.getQuizName());
        return response;
    }

    public List<RecentActivityDto> getRecentActivity(Integer userId) {
        List<AttemptTbl> attempts = attemptRepository.findLastTwoUniqueAttempts(userId);

        if (attempts.isEmpty()) {
            // If no attempts, return a default DTO
            return List.of(new RecentActivityDto("Math", 5, 0),
                    new RecentActivityDto("General Knowledge",6,0));
        }

        // Map AttemptTbl to RecentActivityDto
        return attempts.stream()
                .map(a -> new RecentActivityDto(a.getQuizName(), a.getQuizId(), a.getScore()))
                .toList();
    }
}
