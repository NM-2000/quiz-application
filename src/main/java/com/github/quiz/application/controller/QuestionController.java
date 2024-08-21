package com.github.quiz.application.controller;

import com.github.quiz.application.entity.Question;
import com.github.quiz.application.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/all")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/all/category/{category}")
    public List<Question> getAllQuestionsByCategory(@PathVariable String category) {
        return questionService.getAllQuestionsByCategory(category);
    }

    @GetMapping("/{id}")
    public Question getQuestion(@PathVariable Integer id) {
        return questionService.getQuestion(id);
    }

    @PostMapping("/create")
    public void createQuestion(@RequestBody Question question) {
        questionService.createQuestion(question);
    }

    @PutMapping("/{id}")
    public void updateQuestion(@RequestBody Question question) {
        questionService.updateQuestion(question);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Integer id) {
        questionService.deleteQuestion(id);
    }

}
