package com.example.QuizAppMonolith.Attempt.Controller;

import com.example.QuizAppMonolith.Attempt.Dto.AttemptRequest;
import com.example.QuizAppMonolith.Attempt.Dto.AttemptResponse;
import com.example.QuizAppMonolith.Attempt.Dto.RecentActivityDto;
import com.example.QuizAppMonolith.Attempt.Service.AttemptService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/attempt")
public class AttemptController {

    private AttemptService attemptService;
    @PostMapping("/submit")
    public ResponseEntity<AttemptResponse> storeAttempt(@RequestBody AttemptRequest attemptRequest){
        log.info("Attempt saved succesfully");
        return ResponseEntity.ok(attemptService.storeAttempt(attemptRequest));
    }

    @GetMapping("/getRecentActivity/{userId}")
    public ResponseEntity<List<RecentActivityDto>> getRecentActivity(@PathVariable  Integer userId){
        log.info("fetching recent 2 activities of user "+userId);
        return ResponseEntity.ok(attemptService.getRecentActivity(userId));
    }
}
