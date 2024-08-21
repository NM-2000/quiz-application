package com.github.quiz.application.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class QuestionWrapper {

    private Integer id;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

}
