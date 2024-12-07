package org.example.survey.repository;

import org.example.survey.model.Assesment;
import org.example.survey.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AssesmentRepository extends JpaRepository<Assesment,Long> {

    List<Assesment> findByUser(User user );
}
