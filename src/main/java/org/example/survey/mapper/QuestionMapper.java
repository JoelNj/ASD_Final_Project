package org.example.survey.mapper;

import org.example.survey.dto.QuestionDto;
import org.example.survey.model.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface QuestionMapper {


    @Mapping(source = "questionDto.category",target="category" )
    Question   questionDtoToQuestion(QuestionDto questionDto);

    @Mapping(source = "question.category",target="category" )
    QuestionDto questionToQuestionDto(Question question);

}
