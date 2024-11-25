package org.example.survey.data;

import org.example.survey.model.Category;
import org.example.survey.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long>  {
}
