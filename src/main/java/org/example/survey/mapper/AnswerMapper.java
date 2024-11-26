package org.example.survey.mapper;



import org.example.survey.dto.AnswerDto;
import org.example.survey.model.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AnswerMapper {

    @Mapping(source = "answerDto.question",target="question" )
    Answer answerDtoToAnswer(AnswerDto answerDto);

    @Mapping(source = "answer.question",target="question" )
    AnswerDto answerToAnswerDto(Answer answer);

}
