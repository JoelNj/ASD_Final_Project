package org.example.survey.repository;

import org.example.survey.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long>  {
}
