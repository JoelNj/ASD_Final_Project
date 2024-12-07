package org.example.survey.service;


import org.example.survey.dto.QuestionDto;
import org.example.survey.exception.RessourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface QuestionService {

    Optional<QuestionDto> addQuestion(Long categoryId, QuestionDto questionRequestDto);
    Optional<QuestionDto> updateQuestion(Long categoryId,Long questionId,QuestionDto questionRequestDto) throws RessourceNotFoundException;
    Optional<QuestionDto> updatePartiallyQuestion(Long categoryId,Long questionId,QuestionDto questionRequestDto) throws RessourceNotFoundException;
    void deleteQuestion(Long questionId) throws RessourceNotFoundException;;
    Optional<List<QuestionDto>> getAllQuestions();
    Optional<QuestionDto> getOneQuestion(Long questionId) throws RessourceNotFoundException;
    Optional<List<QuestionDto>> getKRandomQuestionsBasedOnCategory(int k) throws RessourceNotFoundException;;



}
