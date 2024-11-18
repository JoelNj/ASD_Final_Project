package org.example.survey.service;

import org.example.survey.dto.request.CategoryRequestDto;
import org.example.survey.dto.response.CategoryResponseDto;
import org.example.survey.exception.user.CategoryNotFoundException;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
     Optional<CategoryResponseDto>  add(CategoryRequestDto categoryRequestDto);
     Optional<CategoryResponseDto> updatePartially(Integer categoryId ,CategoryRequestDto categoryRequestDto) throws CategoryNotFoundException;
     Optional<CategoryResponseDto> update(Integer categoryId ,CategoryRequestDto categoryRequestDto) throws CategoryNotFoundException;
     void deleteById(Integer id) throws CategoryNotFoundException;;
     List<CategoryResponseDto> displayAll();
     Optional<CategoryResponseDto> findById(Integer id) throws CategoryNotFoundException;;
}
