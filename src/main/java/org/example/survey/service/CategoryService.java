package org.example.survey.service;

import org.example.survey.dto.CategoryDto;
import org.example.survey.exception.user.CategoryNotFoundException;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
     Optional<CategoryDto>  add(CategoryDto categoryRequestDto);
     Optional<CategoryDto> updatePartially(Integer categoryId ,CategoryDto categoryRequestDto) throws CategoryNotFoundException;
     Optional<CategoryDto> update(Integer categoryId ,CategoryDto categoryRequestDto) throws CategoryNotFoundException;
     void deleteById(Integer id) throws CategoryNotFoundException;;
     List<CategoryDto> displayAll();
     Optional<CategoryDto> findByCategoryId(Integer categoryId) throws CategoryNotFoundException;
}
