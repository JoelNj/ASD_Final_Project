package org.example.survey.service;

import org.example.survey.dto.request.CategoryRequestDto;
import org.example.survey.dto.response.CategoryResponseDto;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
     CategoryResponseDto add(CategoryRequestDto categoryRequestDto);
     CategoryResponseDto update(CategoryRequestDto categoryRequestDto);
     void delete(CategoryRequestDto categoryRequestDto);
     List<CategoryResponseDto> displayAll();
     Optional<CategoryResponseDto> findById(Integer id);
}
