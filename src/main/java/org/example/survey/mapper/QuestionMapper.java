package org.example.survey.mapper;

import org.example.survey.dto.QuestionDto;
import org.example.survey.model.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface QuestionMapper {


    @Mapping(source = "questionDto.category",target="category" )
    @Mapping(target = "questionDto.users", ignore = true)
    @Mapping(target = "questionDto.assessmentQuestions", ignore = true)
    @Mapping(target = "questionDto.answers", ignore = true)
    Question   questionDtoToQuestion(QuestionDto questionDto);

    @Mapping(source = "question.category",target="category" )
    @Mapping(target = "question.users", ignore = true)
    @Mapping(target = "question.assessmentQuestions", ignore = true)
    @Mapping(target = "question.answers", ignore = true)
    QuestionDto questionToQuestionDto(Question question);

}
