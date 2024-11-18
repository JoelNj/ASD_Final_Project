package org.example.survey.controller;


import lombok.RequiredArgsConstructor;
import org.example.survey.dto.request.CategoryRequestDto;
import org.example.survey.dto.response.CategoryResponseDto;
import org.example.survey.exception.user.CategoryNotFoundException;
import org.example.survey.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponseDto> addCategory(@RequestBody CategoryRequestDto categoryRequestDto){
        Optional<CategoryResponseDto> categoryResponseDto = categoryService.add(categoryRequestDto);
        if(categoryResponseDto.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(categoryResponseDto.get());
        }
        else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryResponseDto> updateCategory(@PathVariable Integer categoryId,@RequestBody  CategoryRequestDto categoryRequestDto) throws CategoryNotFoundException {

        Optional<CategoryResponseDto> categoryResponseDto = categoryService.update(categoryId,categoryRequestDto);
        if(categoryResponseDto.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(categoryResponseDto.get());
        }
        throw  new CategoryNotFoundException("Category not found");
    }
    @PatchMapping("/{categoryId}")
    public ResponseEntity<CategoryResponseDto> updatePartiallyCategory(@PathVariable Integer categoryId,@RequestBody CategoryRequestDto categoryRequestDto) throws CategoryNotFoundException {

        Optional<CategoryResponseDto> categoryResponseDto = categoryService.updatePartially(categoryId,categoryRequestDto);
        if(categoryResponseDto.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(categoryResponseDto.get());
        }
        throw  new CategoryNotFoundException("Category not found");
    }
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable  Integer categoryId) throws CategoryNotFoundException {
            categoryService.deleteById(categoryId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> getAllCategories(){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.displayAll());
    }


}
