package com.example.QuizAppMonolith.Login.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Table(name="users")
@Data
@Entity
public class LoginTblEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer userId;

    @Column(name = "username")
    public String userName;

    @Column
    public String password;

    @Column
    public LocalDateTime createdAt;
}
