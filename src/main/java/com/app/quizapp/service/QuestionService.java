package com.app.quizapp.service;

import com.app.quizapp.entity.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getAllQuestions();

    List<Question> getQuestionByCategory(String category);

    String addQuestion(Question question);
}
