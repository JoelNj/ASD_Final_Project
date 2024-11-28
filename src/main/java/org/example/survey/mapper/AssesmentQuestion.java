package org.example.survey.mapper;


import org.example.survey.dto.AssesmentQuestionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AssesmentQuestion {


    @Mapping(source = "assesmentQuestion.question",target="question" )
    @Mapping(source = "assesmentQuestion.assesment",target="assesment" )
    AssesmentQuestionDto assesmentQuestionToAssessmentQuestionDto(AssesmentQuestion assesmentQuestion);

    @Mapping(source = "assesmentQuestionDto.question",target="question" )
    @Mapping(source = "assesmentQuestionDto.assesment",target="assesment" )
    AssesmentQuestion  assesmentQuestionDtoToAssessmentQuestion(AssesmentQuestionDto assesmentQuestionDto);


}
