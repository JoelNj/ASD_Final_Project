package org.example.survey.repository;

import org.example.survey.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Long>  {

    @Query(value = "SELECT * FROM Question   ORDER BY RAND() LIMIT :limit", nativeQuery = true)
    List<Question> findRandomQuestion(@Param("limit") int limit);
}
