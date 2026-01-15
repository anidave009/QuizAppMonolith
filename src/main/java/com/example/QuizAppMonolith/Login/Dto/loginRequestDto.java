package com.example.QuizAppMonolith.Login.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class loginRequestDto {
    public String userName;
    public String password;
}
