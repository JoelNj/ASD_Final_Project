package org.example.survey.service.implementation;

import lombok.RequiredArgsConstructor;
import org.example.survey.data.CategoryRepository;
import org.example.survey.data.QuestionRepository;
import org.example.survey.dto.QuestionDto;
import org.example.survey.exception.user.QuestionNotFoundException;
import org.example.survey.mapper.CategoryMapper;
import org.example.survey.mapper.QuestionMapper;
import org.example.survey.model.Category;
import org.example.survey.model.Question;
import org.example.survey.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class QuestionServiceImplementation implements QuestionService {

    private final QuestionMapper questionMapper;
    private final CategoryRepository categoryRepository ;
    private final QuestionRepository questionRepository;

    @Override
    public Optional<QuestionDto> addQuestion(Integer categoryId , QuestionDto questionDto) {
        Category  category = categoryRepository.findById(categoryId).get();
        Question question = questionMapper.questionDtoToQuestion(questionDto);
        question.setCategory(category);
        Question questionSaved = questionRepository.save(question);
        return Optional.of(questionMapper.questionToQuestionDto(questionSaved));

    }

    @Override
    public Optional<QuestionDto> updateQuestion(Integer categoryId,Long questionId,
                                                        QuestionDto questionDto)  throws QuestionNotFoundException {
        Category  category = categoryRepository.findById(categoryId).get();
        Optional<Question> questionFromDatabase = questionRepository.findById(questionId);
        if(questionFromDatabase.isPresent()){
            questionFromDatabase.get().setCategory(category);
            questionFromDatabase.get().setQuestionText(questionDto.questionText());
            questionFromDatabase.get().setHasAnswer(questionDto.hasAnswer());
            Question questionUpdated = questionRepository.save(questionFromDatabase.get());
            return Optional.of(questionMapper.questionToQuestionDto(questionUpdated));
        }
        throw new QuestionNotFoundException("Question not found");
    }

    @Override
    public Optional<QuestionDto> updatePartiallyQuestion(Integer categoryId,Long questionId,
                                                                 QuestionDto questionDto) throws QuestionNotFoundException {
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
        throw new QuestionNotFoundException("Question not found");
    }

    @Override
    public void deleteQuestion(Long questionId) throws QuestionNotFoundException {
        Optional<Question> questionFromDatabase = questionRepository.findById(questionId);
        if(questionFromDatabase.isPresent()){
            questionRepository.delete(questionFromDatabase.get());
        }
        else{
            throw new QuestionNotFoundException("Question not found");
        }

    }

    @Override
    public Optional<List<QuestionDto>> getAllQuestions() {
        return Optional.of(questionRepository.findAll().stream()
                        . map(questionMapper::questionToQuestionDto).toList()) ;
    }

    @Override
    public Optional<QuestionDto> getOneQuestion(Long questionId) throws QuestionNotFoundException {

        Optional<Question> questionFromDB = questionRepository.findById(questionId);
        if(questionFromDB.isPresent()){
            return Optional.of(questionMapper.questionToQuestionDto(questionFromDB.get()));
        }
        throw new QuestionNotFoundException("Question not found");
    }
}
