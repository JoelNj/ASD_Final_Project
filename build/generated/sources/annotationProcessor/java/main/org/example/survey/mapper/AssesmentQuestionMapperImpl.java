package org.example.survey.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.example.survey.dto.AnswerDto;
import org.example.survey.dto.AssesmentDto;
import org.example.survey.dto.CategoryDto;
import org.example.survey.dto.QuestionDto;
import org.example.survey.dto.RequestAssesmentQuestionDto;
import org.example.survey.dto.ResponseAssesmentQuestionDto;
import org.example.survey.model.Answer;
import org.example.survey.model.Assesment;
import org.example.survey.model.AssesmentQuestion;
import org.example.survey.model.Category;
import org.example.survey.model.Question;
import org.example.survey.model.User;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-09T19:05:56-0600",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class AssesmentQuestionMapperImpl implements AssesmentQuestionMapper {

    @Override
    public ResponseAssesmentQuestionDto assesmentQuestionToResponseAssesmentQuestionDto(AssesmentQuestion assesmentQuestion) {
        if ( assesmentQuestion == null ) {
            return null;
        }

        AssesmentDto assesment = null;
        QuestionDto question = null;
        AnswerDto userAnswer = null;
        Long id = null;
        Boolean isTrue = null;
        Boolean isResponded = null;

        assesment = assesmentToAssesmentDto( assesmentQuestion.getAssesment() );
        question = questionToQuestionDto( assesmentQuestion.getQuestion() );
        userAnswer = answerToAnswerDto( assesmentQuestion.getUserAnswer() );
        id = assesmentQuestion.getId();
        isTrue = assesmentQuestion.getIsTrue();
        isResponded = assesmentQuestion.getIsResponded();

        ResponseAssesmentQuestionDto responseAssesmentQuestionDto = new ResponseAssesmentQuestionDto( id, question, assesment, userAnswer, isTrue, isResponded );

        return responseAssesmentQuestionDto;
    }

    @Override
    public AssesmentQuestion requestAssesmentQuestionDtoToAssesmentQuestion(RequestAssesmentQuestionDto requestAssesmentQuestionDto) {
        if ( requestAssesmentQuestionDto == null ) {
            return null;
        }

        AssesmentQuestion assesmentQuestion = new AssesmentQuestion();

        assesmentQuestion.setIsTrue( requestAssesmentQuestionDto.isTrue() );
        assesmentQuestion.setIsResponded( requestAssesmentQuestionDto.isResponded() );

        return assesmentQuestion;
    }

    protected AssesmentDto assesmentToAssesmentDto(Assesment assesment) {
        if ( assesment == null ) {
            return null;
        }

        Long id = null;
        User user = null;
        String result = null;
        Double percentage = null;
        List<AssesmentQuestion> assessmentQuestions = null;

        id = assesment.getId();
        user = assesment.getUser();
        result = assesment.getResult();
        percentage = assesment.getPercentage();
        List<AssesmentQuestion> list = assesment.getAssessmentQuestions();
        if ( list != null ) {
            assessmentQuestions = new ArrayList<AssesmentQuestion>( list );
        }

        AssesmentDto assesmentDto = new AssesmentDto( id, user, result, percentage, assessmentQuestions );

        return assesmentDto;
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

    protected QuestionDto questionToQuestionDto(Question question) {
        if ( question == null ) {
            return null;
        }

        Long questionId = null;
        String questionText = null;
        Boolean hasAnswer = null;
        CategoryDto category = null;
        List<Answer> answers = null;
        List<AssesmentQuestion> assessmentQuestions = null;

        questionId = question.getQuestionId();
        questionText = question.getQuestionText();
        hasAnswer = question.getHasAnswer();
        category = categoryToCategoryDto( question.getCategory() );
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

    protected AnswerDto answerToAnswerDto(Answer answer) {
        if ( answer == null ) {
            return null;
        }

        Long responseId = null;
        String responseText = null;
        Boolean isTrue = null;
        QuestionDto question = null;
        List<AssesmentQuestion> assessmentQuestions = null;

        responseId = answer.getResponseId();
        responseText = answer.getResponseText();
        isTrue = answer.getIsTrue();
        question = questionToQuestionDto( answer.getQuestion() );
        List<AssesmentQuestion> list = answer.getAssessmentQuestions();
        if ( list != null ) {
            assessmentQuestions = new ArrayList<AssesmentQuestion>( list );
        }

        AnswerDto answerDto = new AnswerDto( responseId, responseText, isTrue, question, assessmentQuestions );

        return answerDto;
    }
}
