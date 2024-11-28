package org.example.survey.controller;


import lombok.RequiredArgsConstructor;
import org.example.survey.dto.CategoryDto;
import org.example.survey.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto categoryDto){
        Optional<CategoryDto> categoryDtoResponseFromService = categoryService.add(categoryDto);
        if(categoryDtoResponseFromService.isPresent()){
            System.out.println(categoryDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(categoryDtoResponseFromService.get());
        }
        else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable Integer categoryId,@RequestBody  CategoryDto categoryDto) throws CategoryNotFoundException {

        Optional<CategoryDto> categoryDtoFromService = categoryService.update(categoryId,categoryDto);
        if(categoryDtoFromService.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(categoryDtoFromService.get());
        }
        throw  new CategoryNotFoundException("Category not found");
    }
    @PatchMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updatePartiallyCategory(@PathVariable Integer categoryId,@RequestBody CategoryDto categoryDto) throws CategoryNotFoundException {

        Optional<CategoryDto> categoryDtoFromService = categoryService.updatePartially(categoryId,categoryDto);
        if(categoryDtoFromService.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(categoryDtoFromService.get());
        }
        throw  new CategoryNotFoundException("Category not found");
    }
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable  Integer categoryId) throws CategoryNotFoundException {
        Optional<CategoryDto> categoryDtoFromDb = categoryService.findByCategoryId(categoryId);
        if(categoryDtoFromDb.isPresent()){
            categoryService.deleteById(categoryId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        throw  new CategoryNotFoundException("Category not found");
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.displayAll());
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getOneCategory(@PathVariable Integer categoryId) throws CategoryNotFoundException {
        Optional<CategoryDto> categoryDtoFromDb = categoryService.findByCategoryId(categoryId);
        if(categoryDtoFromDb.isPresent()){
            return ResponseEntity.ok(categoryDtoFromDb.get());
        }
        throw  new CategoryNotFoundException("Category not found");

    }


}
