package org.example.survey.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.example.survey.model.Category;

public record QuestionDto(Long questionId,
                          String questionText,
                          Boolean hasAnswer,
                         @JsonIgnore CategoryDto category)
{
}

