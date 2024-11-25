package org.example.survey.service;

import org.example.survey.dto.AnswerDto;
import org.example.survey.exception.user.AnswerNotFoundException;

import java.util.List;
import java.util.Optional;

public interface AnswerService {
    Optional<AnswerDto> addAnswer(Long questionId, AnswerDto answerDto);
    Optional<AnswerDto> updateAnswer(Long questionId, Long answerId,AnswerDto answerRequestDto) throws AnswerNotFoundException;
    Optional<AnswerDto> updateAnswerPartially(Long questionId, Long answerId,AnswerDto answerRequestDto) throws AnswerNotFoundException;
    Optional<Void> deleteAnswer(Long answerId) throws AnswerNotFoundException;
    Optional<List<AnswerDto>> getAllAnswers();
}
