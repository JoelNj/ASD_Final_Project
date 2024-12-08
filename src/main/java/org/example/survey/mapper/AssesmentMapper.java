package org.example.survey.mapper;

import jakarta.transaction.Transactional;
import org.example.survey.dto.AssesmentDto;
import org.example.survey.dto.CategoryDto;
import org.example.survey.model.Assesment;
import org.example.survey.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AssesmentMapper {

    @Mapping(source = "assesmentDto.user",target="user" )
    @Mapping(target = "assessmentQuestions", ignore = true)
    @Transactional
    Assesment assesmentDtoToAssesment (AssesmentDto assesmentDto);

    @Mapping(source = "assesment.user",target="user" )
    @Transactional
    AssesmentDto assesmentToAssesmentDto(Assesment assesment);

}
