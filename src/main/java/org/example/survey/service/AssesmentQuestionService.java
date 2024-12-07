package org.example.survey.service;

import org.example.survey.dto.AnswerDto;
import org.example.survey.dto.RequestAssesmentQuestionDto;
import org.example.survey.dto.ResponseAssesmentQuestionDto;
import org.example.survey.exception.RessourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface AssesmentQuestionService {

    Optional<ResponseAssesmentQuestionDto> addAssesmentQuestion(Long assesmentId, Long questionId ,RequestAssesmentQuestionDto requestAssesmentQuestionDto);

    Optional<ResponseAssesmentQuestionDto>  updateAssesmentQuestionWithUserResponse(Long assesmentQuestionId, AnswerDto answerDto)
            throws RessourceNotFoundException;

    void deleteAssesmentQuestion(Long assementQuestionId)
            throws RessourceNotFoundException;


    Optional<List<ResponseAssesmentQuestionDto>> getAllQuestionForAssesment(Long assesmentId);

    Optional<ResponseAssesmentQuestionDto> getOneQuestioninAssesment(Long assesmentId,Long questionId)
            throws RessourceNotFoundException;

    Boolean userResponseToQuestion (Long assesmentId,Long questionId)
            throws RessourceNotFoundException;


}
