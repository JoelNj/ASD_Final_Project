package org.example.survey.service.implementation;

import lombok.RequiredArgsConstructor;
import org.example.survey.data.AnswerRepository;
import org.example.survey.data.QuestionRepository;
import org.example.survey.dto.AnswerDto;
import org.example.survey.exception.user.RessourceNotFoundException;
import org.example.survey.mapper.AnswerMapper;
import org.example.survey.model.Answer;
import org.example.survey.model.Question;
import org.example.survey.service.AnswerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnswerServiceImplementation  implements AnswerService {

     private final QuestionRepository questionRepository;
     private final  AnswerRepository answerRepository;
     private final AnswerMapper answerMapper ;

    @Override
    public Optional<AnswerDto> addAnswer(Long questionId, AnswerDto answerDto) {
        Question  questionFromDB = questionRepository.findById(questionId).get();
        Answer answer = answerMapper.answerDtoToAnswer(answerDto);
        answer.setQuestion(questionFromDB);
        Answer answerSaved = answerRepository.save(answer);
        return Optional.of(answerMapper.answerToAnswerDto(answerSaved));
    }

    @Override
    public Optional<AnswerDto> updateAnswer(Long questionId, Long answerId, AnswerDto answerDto) throws RessourceNotFoundException {
        Question  questionFromDB = questionRepository.findById(questionId).get();
        Optional<Answer>answerFromDB = answerRepository.findById(answerId);
        if(answerFromDB.isPresent()){
            answerFromDB.get().setQuestion(questionFromDB);
            answerFromDB.get().setIsTrue(answerDto.isTrue());
            answerFromDB.get().setResponseText(answerDto.responseText());
            return Optional.of(answerMapper.answerToAnswerDto(answerRepository.save(answerFromDB.get())));
        }
        throw new RessourceNotFoundException("Answer not found ");
    }

    @Override
    public Optional<AnswerDto> updateAnswerPartially(Long questionId, Long answerId, AnswerDto answerDto) throws RessourceNotFoundException {
        Question  questionFromDB = questionRepository.findById(questionId).get();
        Optional<Answer>answerFromDB = answerRepository.findById(answerId);
        if(answerFromDB.isPresent()){
            answerFromDB.get().setQuestion(questionFromDB);
            if(answerDto.isTrue()!=null){
                answerFromDB.get().setIsTrue(answerDto.isTrue());
            }
            if(answerDto.responseText()!=null){
                answerFromDB.get().setResponseText(answerDto.responseText());
            }
            return Optional.of(answerMapper.answerToAnswerDto(answerRepository.save(answerFromDB.get())));
        }
        throw new RessourceNotFoundException("Answer not found ");
    }

    @Override
    public void deleteAnswer(Long answerId) throws RessourceNotFoundException {
        Optional<Answer> answerTODelete = answerRepository.findById(answerId);
        if ( answerTODelete.isPresent() ) {
            answerRepository.delete(answerTODelete.get());
        }
        throw new RessourceNotFoundException("Answer not found ");
    }

    @Override
    public Optional<List<AnswerDto>> getAllAnswers() {
        List<AnswerDto> answers = answerRepository.findAll().stream()
                .map(answerMapper::answerToAnswerDto).toList();
        return Optional.of(answers);
    }

    @Override
    public Optional<AnswerDto> getOneAnswer(Long questionId) throws RessourceNotFoundException {
        Optional<Answer> answerFromDB = answerRepository.findById(questionId);
        if(answerFromDB.isPresent()){
            return Optional.of(answerMapper.answerToAnswerDto(answerFromDB.get()));
        }
        throw new RessourceNotFoundException("Answer not found ");
    }
}
