package org.example.survey.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.example.survey.model.Category;

public record QuestionDto(Long questionId,
                          String questionText,
                          Boolean hasAnswer,
                          CategoryDto category)
{
}

