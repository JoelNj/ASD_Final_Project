package org.example.survey.service;

import org.example.survey.dto.AnswerDto;
import org.example.survey.dto.AssesmentDto;
import org.example.survey.exception.RessourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface AssesmentService {

      Optional<AssesmentDto> addAssesment(Long userId,AssesmentDto assesmentDto);
      Optional<AssesmentDto> updateAssesment(Long assesmentId, AssesmentDto assesmentDto) throws RessourceNotFoundException;
      void deleteAssesment(Long assesmentId) throws RessourceNotFoundException;
      Optional<List<AssesmentDto>> getAllAssesments();
      Optional<List<AssesmentDto>> getListAssesmentByUserId(Long userId) throws RessourceNotFoundException;
      Optional<AssesmentDto> getOneAssesmentById(Long assesmentId) throws RessourceNotFoundException;


}
