package org.example.survey.service.implementation;

import lombok.RequiredArgsConstructor;
import org.example.survey.data.AssesmentQuestionRepository;
import org.example.survey.data.AssesmentRepository;
import org.example.survey.data.QuestionRepository;
import org.example.survey.dto.AssesmentQuestionDto;
import org.example.survey.exception.user.RessourceNotFoundException;
import org.example.survey.service.AssesmentQuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssesmentQuestionImplementation implements AssesmentQuestionService {

    private  final AssesmentQuestionRepository assesmentQuestionRepository;
    private final QuestionRepository questionRepository;
    private final AssesmentRepository assesmentRepository;


    @Override
    public Optional<AssesmentQuestionDto> addAssesmentQuestion(Long assesmentId, AssesmentQuestionDto assesmentQuestionDto) {

        return Optional.empty();
    }

    @Override
    public Optional<AssesmentQuestionDto> updateAssesmentQuestion(Long assesmentId, Long assesmentQuestionId, AssesmentQuestionDto assesmentQuestionDto) throws RessourceNotFoundException {
        return Optional.empty();
    }

    @Override
    public Optional<AssesmentQuestionDto> updatePartiallyAssesmentQuestion(Long assesmentId, Long assesmentQuestionId, AssesmentQuestionDto assesmentQuestionDto) throws RessourceNotFoundException {
        return Optional.empty();
    }

    @Override
    public void deleteAssesmentQuestion(Long assesmentQuestionId) throws RessourceNotFoundException {

    }

    @Override
    public Optional<List<AssesmentQuestionDto>> getAllQuestionForAssesment(Long assesmentId) {
        return Optional.empty();
    }

    @Override
    public Optional<AssesmentQuestionDto> getOneQuestioninAssesment(Long assesmentId) throws RessourceNotFoundException {
        return Optional.empty();
    }
}
