package com.app.quizapp.repo;

import com.app.quizapp.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface QuestionRepo extends JpaRepository<Question,Integer> {

    List<Question> findAllByCategory(String category);

    List<Question> findAllByCategoryEqualsAndAndDifficultyEquals(String category, String difficulty);
}
