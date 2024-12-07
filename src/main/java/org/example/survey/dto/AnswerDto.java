package org.example.survey.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public record AnswerDto(Long responseId,
                        String responseText,
                        Boolean isTrue,
                        @JsonIgnore QuestionDto question
                       )
{
}


