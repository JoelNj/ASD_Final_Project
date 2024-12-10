package org.example.survey.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.example.survey.dto.CategoryDto;
import org.example.survey.model.Category;
import org.example.survey.model.Question;
import org.example.survey.model.User;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-09T19:15:59-0600",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category categoryDtoToCategory(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        Category category = new Category();

        if ( categoryDto.categoryId() != null ) {
            category.setCategoryId( categoryDto.categoryId().longValue() );
        }
        category.setLabel( categoryDto.label() );
        category.setNumberOfQuestion( categoryDto.numberOfQuestion() );

        return category;
    }

    @Override
    public CategoryDto categoryToCategoryDto(Category category) {
        if ( category == null ) {
            return null;
        }

        Integer categoryId = null;
        String label = null;
        Integer numberOfQuestion = null;
        List<User> users = null;
        List<Question> questions = null;

        if ( category.getCategoryId() != null ) {
            categoryId = category.getCategoryId().intValue();
        }
        label = category.getLabel();
        numberOfQuestion = category.getNumberOfQuestion();
        List<User> list = category.getUsers();
        if ( list != null ) {
            users = new ArrayList<User>( list );
        }
        List<Question> list1 = category.getQuestions();
        if ( list1 != null ) {
            questions = new ArrayList<Question>( list1 );
        }

        CategoryDto categoryDto = new CategoryDto( categoryId, label, numberOfQuestion, users, questions );

        return categoryDto;
    }
}
