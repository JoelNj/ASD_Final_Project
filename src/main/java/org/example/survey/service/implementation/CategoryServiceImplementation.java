package org.example.survey.service.implementation;

import lombok.RequiredArgsConstructor;
import org.example.survey.exception.RessourceNotFoundException;
import org.example.survey.repository.CategoryRepository;
import org.example.survey.dto.CategoryDto;
import org.example.survey.mapper.CategoryMapper;
import org.example.survey.model.Category;
import org.example.survey.repository.UserRepository;
import org.example.survey.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryServiceImplementation implements CategoryService {

    private final CategoryMapper categoryMapper;

    private final CategoryRepository categoryRepository ;



    @Override
    public Optional<CategoryDto>  add(CategoryDto categoryDto) {
        Category category = categoryMapper.categoryDtoToCategory(categoryDto);
        Category categoryReturned = categoryRepository.save(category);
        return Optional.of(categoryMapper.categoryToCategoryDto(categoryReturned));
    }

    @Override
    public Optional<CategoryDto> updatePartially(Long categoryId, CategoryDto categoryDto) throws RessourceNotFoundException {
        Optional<Category> category = categoryRepository.findByCategoryId(categoryId);
        if(category.isPresent()){
            if(categoryDto.label()!=null){
                category.get().setLabel(categoryDto.label());
            }
            if(categoryDto.numberOfQuestion()!=null){
                category.get().setNumberOfQuestion(categoryDto.numberOfQuestion());
            }
            Category categorySaved =  categoryRepository.save(category.get());
            return Optional.of(categoryMapper.categoryToCategoryDto(categorySaved));
        }
        throw new RessourceNotFoundException("Category not found");
    }

    @Override
    public Optional<CategoryDto> update(Long categoryId ,CategoryDto categoryDto) throws RessourceNotFoundException {
        Optional<Category> category = categoryRepository.findByCategoryId(categoryId);
        if(category.isPresent()){
            category.get().setLabel(categoryDto.label());
            category.get().setNumberOfQuestion(categoryDto.numberOfQuestion());
            Category categorySaved =  categoryRepository.save(category.get());
            return Optional.of(categoryMapper.categoryToCategoryDto(categorySaved));
        }
        throw new RessourceNotFoundException("Category not found");
    }

    @Override
    public void deleteById(Long categoryId) throws RessourceNotFoundException {
        Optional<Category> categoryToDelete = categoryRepository.findByCategoryId(categoryId);
        if(categoryToDelete.isPresent()){
            categoryRepository.delete(categoryToDelete.get());
        }
        else{
            throw new RessourceNotFoundException("Category not found ");
        }
    }

    @Override
    public List<CategoryDto> displayAll() {
        return categoryRepository.findAll().stream().sorted(Comparator.comparing(Category::getLabel))
                                 .map(categoryMapper::categoryToCategoryDto).toList();
    }


    @Override
    public Optional<CategoryDto> findByCategoryId(Long categoryId) throws RessourceNotFoundException {
        Optional<Category> categoryDtoFromb = categoryRepository.findByCategoryId(categoryId);
        if(categoryDtoFromb.isPresent()){
            return Optional.of(categoryMapper.categoryToCategoryDto(categoryDtoFromb.get()));
        }
        throw  new RessourceNotFoundException("Category not found message ");
    }
}
