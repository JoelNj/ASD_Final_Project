package org.example.survey.mapper;



import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.survey.dto.AnswerDto;
import org.example.survey.dto.QuestionDto;
import org.example.survey.model.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AnswerMapper {

    @Mapping(source = "answerDto.question",target="question" )
    @Mapping(source = "answerDto.responseId",target="responseId" )
    @Mapping(source = "answerDto.responseText",target="responseText" )
    @Mapping(source = "answerDto.isTrue",target="isTrue" )
    @Mapping(target = "answerDto.assessmentQuestions", ignore = true)


    Answer answerDtoToAnswer(AnswerDto answerDto);

    @Mapping(source = "answer.question",target="question" )
    @Mapping(source = "answer.responseId",target="responseId" )
    @Mapping(source = "answer.responseText",target="responseText" )
    @Mapping(source = "answer.isTrue",target="isTrue" )
    @Mapping(target = "answer.questions", ignore = true)
    @Mapping(target = "answer.users", ignore = true)
    @Mapping(target = "answer.assessmentQuestions", ignore = true)
    AnswerDto answerToAnswerDto(Answer answer);


}
