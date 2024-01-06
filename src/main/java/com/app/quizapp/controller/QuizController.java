package com.app.quizapp.controller;

import com.app.quizapp.dto.GetQuestionDTO;
import com.app.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/quiz")

public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam String difficulty){
        return new ResponseEntity<String>(
                quizService.createQuiz(category,difficulty),
                HttpStatus.OK
        );
    }

    @GetMapping("get-questions/{id}")
    public ResponseEntity<List<GetQuestionDTO>> getQuizQuestions(@PathVariable Integer id){
        return new ResponseEntity<List<GetQuestionDTO>>(
                quizService.getQuizQuestions(id),
                HttpStatus.OK
        );
    }
}
