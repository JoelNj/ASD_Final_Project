package org.example.survey.mapper;

import org.example.survey.dto.request.CategoryRequestDto;
import org.example.survey.dto.response.CategoryResponseDto;
import org.example.survey.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(source = "categoryId", target = "categoryId")
    @Mapping(source = "label", target = "label")
    @Mapping(source = "numberOfQuestion", target = "numberOfQuestion")
    Category categoryRequestDtoToCategory(CategoryRequestDto categoryRequestDto);

    @Mapping(source = "categoryId", target = "categoryId")
    @Mapping(source = "label", target = "label")
    @Mapping(source = "numberOfQuestion", target = "numberOfQuestion")
    CategoryResponseDto categoryToCategoryResponseDto(Category category);
}
