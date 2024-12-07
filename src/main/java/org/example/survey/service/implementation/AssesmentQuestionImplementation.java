package org.example.survey.service.implementation;

import lombok.RequiredArgsConstructor;
import org.example.survey.dto.AnswerDto;
import org.example.survey.dto.RequestAssesmentQuestionDto;
import org.example.survey.dto.ResponseAssesmentQuestionDto;
import org.example.survey.exception.RessourceNotFoundException;
import org.example.survey.mapper.AnswerMapper;
import org.example.survey.mapper.AssesmentQuestionMapper;
import org.example.survey.model.Answer;
import org.example.survey.model.Assesment;
import org.example.survey.model.AssesmentQuestion;
import org.example.survey.model.Question;
import org.example.survey.repository.AssesmentQuestionRepository;
import org.example.survey.repository.AssesmentRepository;
import org.example.survey.repository.QuestionRepository;
import org.example.survey.service.AssesmentQuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssesmentQuestionImplementation implements AssesmentQuestionService  {
    private final AssesmentQuestionRepository assesmentQuestionRepository;
    private final QuestionRepository questionRepository;
    private final AssesmentRepository assesmentRepository;
    private final AssesmentQuestionMapper assesmentQuestionMapper;
    private final AnswerMapper answerMapper;



    @Override
    public Optional<ResponseAssesmentQuestionDto> addAssesmentQuestion(Long assesmentId, Long questionId, RequestAssesmentQuestionDto requestAssesmentQuestionDto) {
        AssesmentQuestion assesmentQuestion = assesmentQuestionMapper.requestAssesmentQuestionDtoToAssesmentQuestion(requestAssesmentQuestionDto);
        Question question = questionRepository.getReferenceById(questionId);
        Assesment assesment = assesmentRepository.getReferenceById(assesmentId);
        assesmentQuestion.setAssesment(assesment);
        assesmentQuestion.setQuestion(question);
        assesmentQuestion.setUserAnswer(null);
        AssesmentQuestion assesmentQuestionSaved = assesmentQuestionRepository.save(assesmentQuestion);
        return Optional.of(assesmentQuestionMapper.assesmentQuestionToResponseAssesmentQuestionDto(assesmentQuestionSaved));
    }

    @Override
    public Optional<ResponseAssesmentQuestionDto> updateAssesmentQuestionWithUserResponse(Long assesmentQuestionId, AnswerDto answerDto) throws RessourceNotFoundException {

        Optional<AssesmentQuestion> assesmentQuestion = assesmentQuestionRepository.getAssesmentQuestionsById(assesmentQuestionId);
        if(assesmentQuestion.isPresent()){
            Answer answer = answerMapper.answerDtoToAnswer(answerDto);
            assesmentQuestion.get().setUserAnswer(answer);
            Optional<Answer> answerToCompareTo =  assesmentQuestion.get().getQuestion().getAnswers().stream().filter(Answer::getIsTrue).findFirst();
            if(answerToCompareTo.isPresent()){
               if(answerToCompareTo.get().getResponseText().equals(answer.getResponseText())) {
                   assesmentQuestion.get().setIsTrue(true);
               }
            }
            assesmentQuestion.get().setIsResponded(true);
            AssesmentQuestion assesmentQuestionSaved = assesmentQuestionRepository.save(assesmentQuestion.get());
            // Modifie the assesment
            long countNumberOfQuestionForAssesment = assesmentQuestion.get().getAssesment().getAssessmentQuestions().stream().count();
            long countNumberOfQuestionThatAreTrue = assesmentQuestion.get().getAssesment().getAssessmentQuestions().stream().filter(AssesmentQuestion::getIsTrue).count();
            double percentage = (countNumberOfQuestionThatAreTrue*100)/countNumberOfQuestionForAssesment;
            assesmentQuestion.get().getAssesment().setPercentage(percentage);
            if(percentage>50){
                assesmentQuestion.get().getAssesment().setResult("passed");
            }
            assesmentRepository.save(assesmentQuestion.get().getAssesment());
            return Optional.of(assesmentQuestionMapper.assesmentQuestionToResponseAssesmentQuestionDto(assesmentQuestionSaved));
        }
        throw new RessourceNotFoundException("Ressource not find");


    }

    @Override
    public void deleteAssesmentQuestion(Long assementQuestionId) throws RessourceNotFoundException {
        Optional<AssesmentQuestion> assesmentQuestion = assesmentQuestionRepository.findById(assementQuestionId);
        if(assesmentQuestion.isPresent()){
            assesmentQuestionRepository.delete(assesmentQuestion.get());
        }
        throw new RessourceNotFoundException("Ressource not find");
    }

    @Override
    public Optional<List<ResponseAssesmentQuestionDto>> getAllQuestionForAssesment(Long assesmentId) {
        return Optional.of(assesmentQuestionRepository.findAll().stream().map(assesmentQuestionMapper::assesmentQuestionToResponseAssesmentQuestionDto).toList());
    }

    @Override
    public Optional<ResponseAssesmentQuestionDto> getOneQuestioninAssesment(Long assesmentId, Long questionId) throws RessourceNotFoundException {
        return Optional.empty();
    }

    @Override
    public Boolean userResponseToQuestion(Long assesmentId, Long questionId) throws RessourceNotFoundException {
        return null;
    }
}
