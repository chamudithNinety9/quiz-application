package com.app.quizapp.entity;

import com.app.quizapp.entity.enums.DifficultyLevels;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "question")

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Question {

    @Id
    @Column(name = "question_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int questionId;

    @Column(name = "category")
    private String category;

//    @Enumerated(EnumType.STRING)
//    @Column(name = "difficulty_level")
//    private DifficultyLevels difficultyLevels;
    @Column(name = "difficulty_level")
    private String difficulty;

    @Column(name = "option1")
    private String option1;

    @Column(name = "option2")
    private String option2;

    @Column(name = "option3")
    private String option3;

    @Column(name = "option4")
    private String option4;

    @Column(name = "question_title")
    private String question_title;

    @Column(name = "right_answer")
    private String right_answer;
}
