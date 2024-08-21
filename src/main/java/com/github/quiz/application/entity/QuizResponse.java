package com.github.quiz.application.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuizResponse {

    private Integer Id;
    private String answer;

}
