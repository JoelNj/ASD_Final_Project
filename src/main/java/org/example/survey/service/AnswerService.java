package org.example.survey.service;

import org.example.survey.dto.AnswerDto;
import org.example.survey.exception.RessourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface AnswerService {
    Optional<AnswerDto> addAnswer(Long questionId, AnswerDto answerDto);
    Optional<AnswerDto> updateAnswer(Long questionId, Long answerId,AnswerDto answerDto) throws RessourceNotFoundException;
    Optional<AnswerDto> updateAnswerPartially(Long questionId, Long answerId,AnswerDto answerDto) throws RessourceNotFoundException;
    void deleteAnswer(Long answerId) throws RessourceNotFoundException;
    Optional<List<AnswerDto>> getAllAnswers();
    Optional<AnswerDto> getOneAnswer(Long questionId) throws RessourceNotFoundException;
}
