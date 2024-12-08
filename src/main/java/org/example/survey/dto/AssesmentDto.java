package org.example.survey.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import org.example.survey.model.AssesmentQuestion;
import org.example.survey.model.User;

import java.util.List;

public record AssesmentDto(Long id,
                           @JsonIgnore User user,
                           String result,
                           Double percentage,
                           List<AssesmentQuestion> assessmentQuestions) {
}

