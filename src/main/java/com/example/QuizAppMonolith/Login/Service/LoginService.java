package com.example.QuizAppMonolith.Login.Service;

import com.example.QuizAppMonolith.Login.Dto.loginRequestDto;
import com.example.QuizAppMonolith.Login.Model.LoginTblEntity;
import com.example.QuizAppMonolith.Login.Repository.LoginRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    public Boolean userAuthentication(loginRequestDto loginRequest) {
        try {
            Optional<LoginTblEntity> userOptional = loginRepository.findByUserNameAndPassword(
                    loginRequest.getUserName(),
                    loginRequest.getPassword()
            );

            if (userOptional.isPresent()) {
                log.info("User authenticated successfully: {}", loginRequest.getUserName());
                return true;
            } else {
                log.warn("Authentication failed for user: {}", loginRequest.getUserName());
                return false;
            }

        } catch (Exception e) {
            log.error("Error during authentication: {}", e.getMessage());
            return false;
        }
    }
}
