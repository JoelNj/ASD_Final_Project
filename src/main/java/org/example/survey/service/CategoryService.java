package org.example.survey.service;

import org.example.survey.dto.request.CategoryRequestDto;
import org.example.survey.dto.response.CategoryResponseDto;
import org.example.survey.exception.user.UserNotFoundException;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
     Optional<CategoryResponseDto>  add(CategoryRequestDto categoryRequestDto);
     Optional<CategoryResponseDto> updatePartially(Integer categoryId ,CategoryRequestDto categoryRequestDto) throws UserNotFoundException;
     Optional<CategoryResponseDto> update(Integer categoryId ,CategoryRequestDto categoryRequestDto) throws UserNotFoundException;
     void delete(CategoryRequestDto categoryRequestDto) throws UserNotFoundException;;
     List<CategoryResponseDto> displayAll();
     Optional<CategoryResponseDto> findById(Integer id) throws UserNotFoundException;;
}
