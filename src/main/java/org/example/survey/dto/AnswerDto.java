package org.example.survey.dto;

public record AnswerDto(Long responseId,
                        String responseText,
                        Boolean isTrue,
                        QuestionDto question
                       )
{
}


