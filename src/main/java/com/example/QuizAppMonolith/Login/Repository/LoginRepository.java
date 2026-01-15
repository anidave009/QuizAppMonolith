package com.example.QuizAppMonolith.Login.Repository;

import com.example.QuizAppMonolith.Login.Model.LoginTblEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<LoginTblEntity,Integer> {
    Optional<LoginTblEntity> findByUserNameAndPassword(String userName, String password);
}
