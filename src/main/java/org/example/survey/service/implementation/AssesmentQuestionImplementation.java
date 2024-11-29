package org.example.survey.service.implementation;

import lombok.RequiredArgsConstructor;
import org.example.survey.repository.AssesmentQuestionRepository;
import org.example.survey.repository.AssesmentRepository;
import org.example.survey.repository.QuestionRepository;
import org.example.survey.dto.assesmentquestion.AssesmentQuestionDto;
import org.example.survey.exception.user.RessourceNotFoundException;
import org.example.survey.service.AssesmentQuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssesmentQuestionImplementation implements AssesmentQuestionService {

    private  final AssesmentQuestionRepository assesmentQuestionRepository; // Assesment question operations
    private final QuestionRepository questionRepository;// List of Random 10 questions from database
    private final AssesmentRepository assesmentRepository; // Filter my assesment based on id


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
