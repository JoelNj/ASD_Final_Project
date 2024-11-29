package org.example.survey.dto;

import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import org.example.survey.model.User;

public record AssesmentDto(Long id,User user,String result,Double percentage) {
}

