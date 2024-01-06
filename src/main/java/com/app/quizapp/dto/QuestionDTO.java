package com.app.quizapp.dto;

import com.app.quizapp.entity.enums.DifficultyLevels;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class QuestionDTO {

    private int questionId;
    private String category;
    private String difficulty;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String question_title;
    private String right_answer;

}
