package org.example.survey.service;

import org.example.survey.dto.CategoryDto;
import org.example.survey.exception.RessourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
     Optional<CategoryDto>  add(CategoryDto categoryRequestDto);
     Optional<CategoryDto> updatePartially(Long categoryId ,CategoryDto categoryRequestDto) throws RessourceNotFoundException;
     Optional<CategoryDto> update(Long categoryId ,CategoryDto categoryRequestDto) throws RessourceNotFoundException;
     void deleteById(Long id) throws RessourceNotFoundException;;
     List<CategoryDto> displayAll();
     Optional<CategoryDto> findByCategoryId(Long categoryId) throws RessourceNotFoundException;
}
