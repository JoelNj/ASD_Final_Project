package org.example.survey.dto;



public record AssesmentQuestionDto(Long id, QuestionDto question,AssesmentDto assesment, Boolean isTrue,Boolean isResponded) {
}


