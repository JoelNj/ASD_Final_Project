package org.example.survey.dto;

import jakarta.persistence.*;
import org.example.survey.model.Answer;
import org.example.survey.model.Assesment;
import org.example.survey.model.Question;

public record ResponseAssesmentQuestionDto(Long id,QuestionDto question,
                                           AssesmentDto assesment,
                                           AnswerDto userAnswer,
                                           Boolean isTrue,
                                           Boolean isResponded) {
}

