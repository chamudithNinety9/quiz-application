package com.app.quizapp.service;

import com.app.quizapp.dto.GetQuestionDTO;

import java.util.List;

public interface QuizService {
    String createQuiz(String category, String difficulty);

    List<GetQuestionDTO> getQuizQuestions(Integer id);
}
