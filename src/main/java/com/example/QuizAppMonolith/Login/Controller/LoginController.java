package com.example.QuizAppMonolith.Login.Controller;

import com.example.QuizAppMonolith.Login.Dto.loginRequestDto;
import com.example.QuizAppMonolith.Login.Service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping("/authenticate")
    public ResponseEntity<Boolean> userAuthentication(@RequestBody loginRequestDto loginrequest){
        log.info("Request Reached and now further proceding for searching the user in db");
        Boolean userFound=loginService.userAuthentication(loginrequest);
        if(userFound){
            log.info("User Exists and is authenticated");
            return ResponseEntity.ok(true);
        }
        log.info("User Does not exists , pls register yourself, or data incorrect");
        return ResponseEntity.ok(false);
    }
}
