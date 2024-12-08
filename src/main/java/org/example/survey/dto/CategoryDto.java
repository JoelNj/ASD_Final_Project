package org.example.survey.dto;

import org.example.survey.model.Question;
import org.example.survey.model.User;

import java.util.List;

public record CategoryDto(Integer categoryId, String label,
                          Integer numberOfQuestion,
                          List<User> users,
                          List<Question> questions
                                 ) {
}
