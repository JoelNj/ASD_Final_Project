package org.example.survey.mapper;

import org.example.survey.dto.CategoryDto;
import org.example.survey.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(source = "categoryDto.categoryId",target="categoryId" )
    @Mapping(source = "categoryDto.label",target="label" )
    @Mapping(source = "categoryDto.numberOfQuestion",target="numberOfQuestion" )
    @Mapping(target = "questions", ignore = true)
    @Mapping(target = "users", ignore = true)
    Category categoryDtoToCategory(CategoryDto categoryDto);

    @Mapping(source = "category.categoryId",target="categoryId" )
    @Mapping(source = "category.label",target="label" )
    @Mapping(source = "category.numberOfQuestion",target="numberOfQuestion" )
    @Mapping(target = "category.questions", ignore = true)
    @Mapping(target = "category.users", ignore = true)
    CategoryDto categoryToCategoryDto(Category category);

}
