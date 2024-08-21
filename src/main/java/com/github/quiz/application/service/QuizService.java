package com.github.quiz.application.service;

import com.github.quiz.application.entity.Question;
import com.github.quiz.application.entity.QuestionWrapper;
import com.github.quiz.application.entity.Quiz;
import com.github.quiz.application.entity.QuizResponse;
import com.github.quiz.application.repository.QuestionRepository;
import com.github.quiz.application.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionRepository questionRepository;

    public void createQuiz(String category, Integer numOfQuestions, String title) {
        List<Question> questions = questionRepository.findRandomQuestionsByCategory(category, numOfQuestions);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);

        quizRepository.save(quiz);
    }

    public List<QuestionWrapper> getQuiz(Integer id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        List<Question> questions = quiz.get().getQuestions();

        List<QuestionWrapper> qw = new ArrayList<>();
        for (Question question : questions) {
            qw.add(
                    new QuestionWrapper(
                            question.getId(),
                            question.getQuestion(),
                            question.getOption1(),
                            question.getOption2(),
                            question.getOption3(),
                            question.getOption4()
                    )
            );
        }

        return qw;

    }


    public Integer submitQuiz(Integer id, List<QuizResponse> quizResponse) {
        Quiz quiz = quizRepository.findById(id).get();
        List<Question> questions = quiz.getQuestions();

        int score = 0;
        int index = 0;

        for(QuizResponse response: quizResponse) {
            if(response.getAnswer().equals(questions.get(index).getAnswer())) {
                score++;
            }
            index++;
        }

        return score;

    }
}
