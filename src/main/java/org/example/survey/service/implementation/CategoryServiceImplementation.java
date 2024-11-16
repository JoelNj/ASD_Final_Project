package org.example.survey.service.implementation;

import lombok.RequiredArgsConstructor;
import org.example.survey.data.CategoryRepository;
import org.example.survey.dto.request.CategoryRequestDto;
import org.example.survey.dto.response.CategoryResponseDto;
import org.example.survey.exception.user.UserNotFoundException;
import org.example.survey.mapper.CategoryMapper;
import org.example.survey.model.Category;
import org.example.survey.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryServiceImplementation implements CategoryService {

    private final CategoryMapper categoryMapper;

    private final CategoryRepository categoryRepository ;

    @Override
    public Optional<CategoryResponseDto>  add(CategoryRequestDto categoryRequestDto) {
        Category category = categoryMapper.categoryRequestDtoToCategory(categoryRequestDto);
        Category categoryReturned = categoryRepository.save(category);
        return Optional.of(categoryMapper.categoryToCategoryResponseDto(categoryReturned));
    }

    @Override
    public Optional<CategoryResponseDto> updatePartially(Integer categoryId, CategoryRequestDto categoryRequestDto) throws UserNotFoundException {

        Optional<Category> category = categoryRepository.findByCategoryId(categoryId);
        if(category.isPresent()){
            category.get().setLabel(categoryRequestDto.label());
            category.get().setNumberOfQuestion(categoryRequestDto.numberOfQuestion());
            Category categorySaved =  categoryRepository.save(category.get());
            return Optional.of(categoryMapper.categoryToCategoryResponseDto(categorySaved));
        }
        throw new  UserNotFoundException("The user does not exist");
    }

    @Override
    public Optional<CategoryResponseDto> update(Integer categoryId ,CategoryRequestDto categoryRequestDto) throws UserNotFoundException {
        Optional<Category> category = categoryRepository.findByCategoryId(categoryId);
        if(category.isPresent()){
            category.get().setLabel(categoryRequestDto.label());
            category.get().setNumberOfQuestion(categoryRequestDto.numberOfQuestion());
            Category categorySaved =  categoryRepository.save(category.get());
            return Optional.of(categoryMapper.categoryToCategoryResponseDto(categorySaved));
        }
        throw new  UserNotFoundException("The user does not exist");
    }

    @Override
    public void delete(CategoryRequestDto categoryRequestDto) throws UserNotFoundException {
        Category category = categoryMapper.categoryRequestDtoToCategory(categoryRequestDto);
        if(categoryRepository.findById(category.getCategoryId()).isPresent()){
            categoryRepository.delete(category);
        }
    }

    @Override
    public List<CategoryResponseDto> displayAll() {
        return categoryRepository.findAll().stream().sorted(Comparator.comparing(Category::getLabel))
                                 .map(categoryMapper::categoryToCategoryResponseDto).toList();
    }

    @Override
    public Optional<CategoryResponseDto>  findById(Integer id) throws UserNotFoundException {

        if(categoryRepository.findById(id).isPresent()){
            CategoryResponseDto categoryResponse = categoryMapper.categoryToCategoryResponseDto(categoryRepository.findById(id).get());
            return Optional.of(categoryResponse);
        }
        return Optional.empty();

    }
}
