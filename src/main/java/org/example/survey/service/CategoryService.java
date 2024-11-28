package org.example.survey.service;

import org.example.survey.dto.CategoryDto;
import org.example.survey.exception.user.RessourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
     Optional<CategoryDto>  add(CategoryDto categoryRequestDto);
     Optional<CategoryDto> updatePartially(Integer categoryId ,CategoryDto categoryRequestDto) throws RessourceNotFoundException;
     Optional<CategoryDto> update(Integer categoryId ,CategoryDto categoryRequestDto) throws RessourceNotFoundException;
     void deleteById(Integer id) throws RessourceNotFoundException;;
     List<CategoryDto> displayAll();
     Optional<CategoryDto> findByCategoryId(Integer categoryId) throws RessourceNotFoundException;
}
