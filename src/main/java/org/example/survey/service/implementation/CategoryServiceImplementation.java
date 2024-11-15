package org.example.survey.service.implementation;

import lombok.RequiredArgsConstructor;
import org.example.survey.data.CategoryRepository;
import org.example.survey.dto.request.CategoryRequestDto;
import org.example.survey.dto.response.CategoryResponseDto;
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
    public CategoryResponseDto add(CategoryRequestDto categoryRequestDto) {
        Category category = categoryMapper.categoryRequestDtoToCategory(categoryRequestDto);
        Category categoryReturned = categoryRepository.save(category);
        return  categoryMapper.categoryToCategoryResponseDto(categoryReturned);
    }

    @Override
    public CategoryResponseDto update(CategoryRequestDto categoryRequestDto) {
        Category category = categoryMapper.categoryRequestDtoToCategory(categoryRequestDto);
        if(categoryRepository.findById(category.getCategoryId()).isPresent()) {
            Category categoryUpdated = categoryRepository.save(category);
            return categoryMapper.categoryToCategoryResponseDto(categoryUpdated);
        }
        return null ;
    }

    @Override
    public void delete(CategoryRequestDto categoryRequestDto) {
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
    public Optional<CategoryResponseDto>  findById(Integer id) {

        if(categoryRepository.findById(id).isPresent()){
            CategoryResponseDto categoryResponse = categoryMapper.categoryToCategoryResponseDto(categoryRepository.findById(id).get());
            return Optional.of(categoryResponse);
        }
        return Optional.empty();

    }
}
