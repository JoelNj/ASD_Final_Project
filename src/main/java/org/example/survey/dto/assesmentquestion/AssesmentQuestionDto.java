package org.example.survey.dto.assesmentquestion;


import org.example.survey.dto.AssesmentDto;
import org.example.survey.dto.QuestionDto;

public record AssesmentQuestionDto(Long id, QuestionDto question, AssesmentDto assesment, Boolean isTrue, Boolean isResponded)
{
}


