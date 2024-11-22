package org.example.survey.dto.request;

import org.example.survey.model.Question;

public record AnswerRequestDto(String responseText,
                               Boolean isTrue,
                               QuestionRequestDto question
                               ) {
}


