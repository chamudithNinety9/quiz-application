package com.app.quizapp.service.impl;

import com.app.quizapp.dto.GetQuestionDTO;
import com.app.quizapp.entity.Question;
import com.app.quizapp.entity.Quiz;
import com.app.quizapp.repo.QuestionRepo;
import com.app.quizapp.repo.QuizRepo;
import com.app.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepo quizRepo;

    @Autowired
    private QuestionRepo questionRepo; //bcz questions are stored in quizRepo (quiz.setQuestionList();)

    /*
     * We should map the quiz table and question table
     * one question can be in different quizzes
     * */

    @Override
    public String createQuiz(String category, String difficulty) {

        //method
        List<Question> questions = questionRepo.findAllByCategoryEqualsAndAndDifficultyEquals(category,difficulty);

        Quiz quiz = new Quiz();
        quiz.setQuestionList(questions);
        quizRepo.save(quiz);

        return "Successful!";
    }

    @Override
    public List<GetQuestionDTO> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizRepo.findById(id);
        List<Question> questionList = quiz.get().getQuestionList();
        List<GetQuestionDTO> getQuestionDTOList = new ArrayList<>();

        for(Question q : questionList){
            GetQuestionDTO qw = new GetQuestionDTO(q.getQuestionId(), q.getQuestion_title(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            getQuestionDTOList.add(qw);
        }

        return getQuestionDTOList;
    }

}
