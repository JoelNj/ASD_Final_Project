package org.example.survey.service;

import org.example.survey.dto.AssesmentQuestionDto;
import org.example.survey.exception.user.RessourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface AssesmentQuestionService {

    Optional<AssesmentQuestionDto> addAssesmentQuestion(Long assesmentId, AssesmentQuestionDto assesmentQuestionDto);


    Optional<AssesmentQuestionDto>  updateAssesmentQuestion(Long assesmentId, Long assesmentQuestionId,AssesmentQuestionDto assesmentQuestionDto)
            throws RessourceNotFoundException;

    Optional<AssesmentQuestionDto>  updatePartiallyAssesmentQuestion(Long assesmentId, Long assesmentQuestionId,AssesmentQuestionDto assesmentQuestionDto)
            throws RessourceNotFoundException;

    void deleteAssesmentQuestion(Long assesmentQuestionId)
            throws RessourceNotFoundException;

    Optional<List<AssesmentQuestionDto>> getAllQuestionForAssesment(Long assesmentId);

    Optional<AssesmentQuestionDto> getOneQuestioninAssesment(Long assesmentId)
            throws RessourceNotFoundException;


}
