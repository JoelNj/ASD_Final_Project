package org.example.survey.mapper;

import org.example.survey.dto.AssesmentDto;
import org.example.survey.dto.CategoryDto;
import org.example.survey.model.Assesment;
import org.example.survey.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AssesmentMapper {

    Assesment assesmentDtoToAssesment (AssesmentDto assesmentDto);
    AssesmentDto assesmentToAssesmentDto(Assesment assesment);

}
