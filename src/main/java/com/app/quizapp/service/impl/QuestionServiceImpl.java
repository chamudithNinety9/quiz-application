package com.app.quizapp.service.impl;

import com.app.quizapp.entity.Question;
import com.app.quizapp.repo.QuestionRepo;
import com.app.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepo questionRepo;

    @Override
    public List<Question> getAllQuestions() {
            List<Question> questionList = questionRepo.findAll();
            return questionList;
    }

    @Override
    public List<Question> getQuestionByCategory(String category) {
        List<Question> questions = questionRepo.findAllByCategory(category);
        return questions;
    }

    @Override
    public String addQuestion(Question question) {
        questionRepo.save(question);
        return question.getQuestionId() + " " + "Added Successfully!";
    }


}
