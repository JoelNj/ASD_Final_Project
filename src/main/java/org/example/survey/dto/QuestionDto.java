package org.example.survey.dto.request;

import org.example.survey.model.Category;

public record QuestionRequestDto(String questionText, Boolean hasAnswer, CategoryRequestDto categoryRequestDto,
                                 Category category) {
}
