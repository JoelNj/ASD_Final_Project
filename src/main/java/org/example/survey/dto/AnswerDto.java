package org.example.survey.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.survey.model.AssesmentQuestion;

import java.util.List;

public record AnswerDto(Long responseId,
                        String responseText,
                        Boolean isTrue,
                        @JsonIgnore QuestionDto question,
                        List<AssesmentQuestion> assessmentQuestions
                       )
{
}


