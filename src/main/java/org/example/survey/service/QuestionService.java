package org.example.survey.service;


import org.example.survey.dto.QuestionDto;
import org.example.survey.exception.user.RessourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface QuestionService {

    Optional<QuestionDto> addQuestion(Integer categoryId, QuestionDto questionRequestDto);
    Optional<QuestionDto> updateQuestion(Integer categoryId,Long questionId,QuestionDto questionRequestDto) throws RessourceNotFoundException;
    Optional<QuestionDto> updatePartiallyQuestion(Integer categoryId,Long questionId,QuestionDto questionRequestDto) throws RessourceNotFoundException;
    void deleteQuestion(Long questionId) throws RessourceNotFoundException;;
    Optional<List<QuestionDto>> getAllQuestions();
    Optional<QuestionDto> getOneQuestion(Long questionId) throws RessourceNotFoundException;;


}
