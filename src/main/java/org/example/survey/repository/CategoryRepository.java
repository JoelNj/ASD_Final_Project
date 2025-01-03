package org.example.survey.repository;

import org.example.survey.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Optional<Category> findByCategoryId(Long categoryId);
    Optional<Category> findByLabel(String label);
}
