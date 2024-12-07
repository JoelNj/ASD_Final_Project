package org.example.survey.service.implementation;

import lombok.RequiredArgsConstructor;
import org.example.survey.exception.RessourceNotFoundException;
import org.example.survey.repository.CategoryRepository;
import org.example.survey.repository.QuestionRepository;
import org.example.survey.dto.QuestionDto;
import org.example.survey.mapper.QuestionMapper;
import org.example.survey.model.Category;
import org.example.survey.model.Question;
import org.example.survey.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class QuestionServiceImplementation implements QuestionService {

    private final QuestionMapper questionMapper;
    private final CategoryRepository categoryRepository ;
    private final QuestionRepository questionRepository;

    @Override
    public Optional<QuestionDto> addQuestion(Long categoryId , QuestionDto questionDto) {
        Category  category = categoryRepository.findById(categoryId).get();
        Question question = questionMapper.questionDtoToQuestion(questionDto);
        question.setCategory(category);
        Question questionSaved = questionRepository.save(question);
        return Optional.of(questionMapper.questionToQuestionDto(questionSaved));

    }

    @Override
    public Optional<QuestionDto> updateQuestion(Long categoryId,Long questionId,
                                                        QuestionDto questionDto)  throws RessourceNotFoundException {
        Category  category = categoryRepository.findById(categoryId).get();
        Optional<Question> questionFromDatabase = questionRepository.findById(questionId);
        if(questionFromDatabase.isPresent()){
            questionFromDatabase.get().setCategory(category);
            questionFromDatabase.get().setQuestionText(questionDto.questionText());
            questionFromDatabase.get().setHasAnswer(questionDto.hasAnswer());
            Question questionUpdated = questionRepository.save(questionFromDatabase.get());
            return Optional.of(questionMapper.questionToQuestionDto(questionUpdated));
        }
        throw new RessourceNotFoundException("Question not found");
    }

    @Override
    public Optional<QuestionDto> updatePartiallyQuestion(Long categoryId,Long questionId,
                                                                 QuestionDto questionDto) throws RessourceNotFoundException {
        Optional<Question> questionFromDatabase = questionRepository.findById(questionId);
        Category category = categoryRepository.findById(categoryId).get();
        if(questionFromDatabase.isPresent()){
            questionFromDatabase.get().setCategory(category);
            questionFromDatabase.get().setCategory(category);
            if(questionDto.questionText()!=null){
                questionFromDatabase.get().setQuestionText(questionDto.questionText());
            }
            if(questionDto.hasAnswer()!=null){
                questionFromDatabase.get().setHasAnswer(questionDto.hasAnswer());
            }
            Question questionUpdated = questionRepository.save(questionFromDatabase.get());
            return Optional.of(questionMapper.questionToQuestionDto(questionUpdated));
        }
        throw new RessourceNotFoundException("Question not found");
    }

    @Override
    public void deleteQuestion(Long questionId) throws RessourceNotFoundException {
        Optional<Question> questionFromDatabase = questionRepository.findById(questionId);
        if(questionFromDatabase.isPresent()){
            questionRepository.delete(questionFromDatabase.get());
        }
        else{
            throw new RessourceNotFoundException("Question not found");
        }

    }

    @Override
    public Optional<List<QuestionDto>> getAllQuestions() {
        return Optional.of(questionRepository.findAll().stream()
                        . map(questionMapper::questionToQuestionDto).toList()) ;
    }

    @Override
    public Optional<QuestionDto> getOneQuestion(Long questionId) throws RessourceNotFoundException {

        Optional<Question> questionFromDB = questionRepository.findById(questionId);
        if(questionFromDB.isPresent()){
            return Optional.of(questionMapper.questionToQuestionDto(questionFromDB.get()));
        }
        throw new RessourceNotFoundException("Question not found");
    }

    @Override
    public Optional<List<QuestionDto>> getKRandomQuestionsBasedOnCategory( int k) throws RessourceNotFoundException {
        return Optional.of(questionRepository.findRandomQuestion(k).stream().map(questionMapper::questionToQuestionDto).toList());
    }
}
