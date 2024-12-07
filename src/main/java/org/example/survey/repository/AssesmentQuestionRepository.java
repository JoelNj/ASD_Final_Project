package org.example.survey.repository;

import org.example.survey.model.Assesment;
import org.example.survey.model.AssesmentQuestion;
import org.example.survey.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssesmentQuestionRepository extends JpaRepository<AssesmentQuestion, Long> {

    Optional<AssesmentQuestion> getAssesmentQuestionsById(Long assesmentQuestionId);
}
