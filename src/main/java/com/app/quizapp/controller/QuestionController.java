package com.app.quizapp.controller;

import com.app.quizapp.entity.Question;
import com.app.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/question")

public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/allquestion")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return new ResponseEntity<List<Question>>(
                questionService.getAllQuestions(),
                HttpStatus.OK
        );
    }

    @GetMapping(
            path = "/get-by-category",
            params = "category"
    )
    public ResponseEntity<List<Question>> getAllByCategory(@RequestParam(value = "category") String category){
        return new ResponseEntity<List<Question>>(
                questionService.getQuestionByCategory(category),
                HttpStatus.OK
        );
    }

    @PostMapping(
            path = "/add"
    )
    public ResponseEntity<String> addQuestion(@RequestBody Question question){

        return new ResponseEntity<String>(
                questionService.addQuestion(question),
                HttpStatus.OK
        );
    }
}
