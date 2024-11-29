package org.example.survey.repository;

import org.example.survey.model.AssesmentQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssesmentQuestionRepository extends JpaRepository<AssesmentQuestion, Long> {
}
