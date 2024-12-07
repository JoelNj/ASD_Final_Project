package org.example.survey.mapper;

import org.example.survey.dto.RequestAssesmentQuestionDto;
import org.example.survey.dto.ResponseAssesmentQuestionDto;
import org.example.survey.model.AssesmentQuestion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AssesmentQuestionMapper {



    @Mapping(source = "assesmentQuestion.assesment",target="assesment" )
    @Mapping(source = "assesmentQuestion.question",target="question" )
    @Mapping(source = "assesmentQuestion.userAnswer",target="userAnswer" )
    ResponseAssesmentQuestionDto assesmentQuestionToResponseAssesmentQuestionDto(AssesmentQuestion assesmentQuestion);



    AssesmentQuestion requestAssesmentQuestionDtoToAssesmentQuestion(RequestAssesmentQuestionDto requestAssesmentQuestionDto);



}
