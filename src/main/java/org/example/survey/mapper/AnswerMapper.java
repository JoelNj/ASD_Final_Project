package org.example.survey.mapper;



import org.example.survey.dto.AnswerDto;
import org.example.survey.model.Answer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnswerMapper {

    Answer answerDtoToAnswer(AnswerDto answerDto);
    AnswerDto answerToAnswerDto(Answer answer);

}
