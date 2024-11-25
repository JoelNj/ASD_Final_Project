package org.example.survey.service;


import org.example.survey.dto.QuestionDto;

import java.util.List;
import java.util.Optional;

public interface QuestionService {

    Optional<QuestionDto> addQuestion(Integer categoryId, QuestionDto questionRequestDto);
    Optional<QuestionDto> updateQuestion(Integer categoryId,Long questionId,QuestionDto questionRequestDto);
    Optional<QuestionDto> updatePartiallyQuestion(Integer categoryId,Long questionId,QuestionDto questionRequestDto);
    void deleteQuestion(Long questionId);
    Optional<List<QuestionDto>> getAllQuestions();


}
