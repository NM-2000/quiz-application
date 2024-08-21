package com.github.quiz.application.controller;

import com.github.quiz.application.entity.QuestionWrapper;
import com.github.quiz.application.entity.QuizResponse;
import com.github.quiz.application.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/create")
    public void createQuiz(@RequestParam String category, @RequestParam Integer numOfQuestions, @RequestParam String title) {
        quizService.createQuiz(category, numOfQuestions, title);
    }

    @GetMapping("/{id}")
    public List<QuestionWrapper> getQuiz(@PathVariable Integer id) {
        return quizService.getQuiz(id);
    }

    @PostMapping("/submit/{id}")
    public Integer submitQuiz(@PathVariable Integer id, @RequestBody List<QuizResponse> quizResponse) {
        return quizService.submitQuiz(id, quizResponse);
    }

}
