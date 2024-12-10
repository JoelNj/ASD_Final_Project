package org.example.survey.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.example.survey.dto.CategoryDto;
import org.example.survey.dto.QuestionDto;
import org.example.survey.model.Answer;
import org.example.survey.model.AssesmentQuestion;
import org.example.survey.model.Category;
import org.example.survey.model.Question;
import org.example.survey.model.User;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-09T19:05:55-0600",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class QuestionMapperImpl implements QuestionMapper {

    @Override
    public Question questionDtoToQuestion(QuestionDto questionDto) {
        if ( questionDto == null ) {
            return null;
        }

        Question question = new Question();

        question.setCategory( categoryDtoToCategory( questionDto.category() ) );
        question.setQuestionId( questionDto.questionId() );
        question.setQuestionText( questionDto.questionText() );
        question.setHasAnswer( questionDto.hasAnswer() );
        List<Answer> list = questionDto.answers();
        if ( list != null ) {
            question.setAnswers( new ArrayList<Answer>( list ) );
        }
        List<AssesmentQuestion> list1 = questionDto.assessmentQuestions();
        if ( list1 != null ) {
            question.setAssessmentQuestions( new ArrayList<AssesmentQuestion>( list1 ) );
        }

        return question;
    }

    @Override
    public QuestionDto questionToQuestionDto(Question question) {
        if ( question == null ) {
            return null;
        }

        CategoryDto category = null;
        Long questionId = null;
        String questionText = null;
        Boolean hasAnswer = null;
        List<Answer> answers = null;
        List<AssesmentQuestion> assessmentQuestions = null;

        category = categoryToCategoryDto( question.getCategory() );
        questionId = question.getQuestionId();
        questionText = question.getQuestionText();
        hasAnswer = question.getHasAnswer();
        List<Answer> list = question.getAnswers();
        if ( list != null ) {
            answers = new ArrayList<Answer>( list );
        }
        List<AssesmentQuestion> list1 = question.getAssessmentQuestions();
        if ( list1 != null ) {
            assessmentQuestions = new ArrayList<AssesmentQuestion>( list1 );
        }

        QuestionDto questionDto = new QuestionDto( questionId, questionText, hasAnswer, category, answers, assessmentQuestions );

        return questionDto;
    }

    protected Category categoryDtoToCategory(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        Category category = new Category();

        if ( categoryDto.categoryId() != null ) {
            category.setCategoryId( categoryDto.categoryId().longValue() );
        }
        category.setLabel( categoryDto.label() );
        category.setNumberOfQuestion( categoryDto.numberOfQuestion() );
        List<Question> list = categoryDto.questions();
        if ( list != null ) {
            category.setQuestions( new ArrayList<Question>( list ) );
        }
        List<User> list1 = categoryDto.users();
        if ( list1 != null ) {
            category.setUsers( new ArrayList<User>( list1 ) );
        }

        return category;
    }

    protected CategoryDto categoryToCategoryDto(Category category) {
        if ( category == null ) {
            return null;
        }

        Integer categoryId = null;
        String label = null;
        Integer numberOfQuestion = null;
        List<User> users = null;
        List<Question> questions = null;

        if ( category.getCategoryId() != null ) {
            categoryId = category.getCategoryId().intValue();
        }
        label = category.getLabel();
        numberOfQuestion = category.getNumberOfQuestion();
        List<User> list = category.getUsers();
        if ( list != null ) {
            users = new ArrayList<User>( list );
        }
        List<Question> list1 = category.getQuestions();
        if ( list1 != null ) {
            questions = new ArrayList<Question>( list1 );
        }

        CategoryDto categoryDto = new CategoryDto( categoryId, label, numberOfQuestion, users, questions );

        return categoryDto;
    }
}
