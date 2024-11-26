package org.example.survey.controller;


import lombok.RequiredArgsConstructor;
import org.example.survey.dto.CategoryDto;
import org.example.survey.dto.QuestionDto;
import org.example.survey.exception.user.CategoryNotFoundException;
import org.example.survey.exception.user.QuestionNotFoundException;
import org.example.survey.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/categories/{categoryId}/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService ;

    @PostMapping
    public ResponseEntity<QuestionDto> addQuestion(@PathVariable Integer categoryId,@RequestBody QuestionDto questionDto ){
        Optional<QuestionDto> questionCreated = questionService.addQuestion(categoryId,questionDto);
        if(questionCreated.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(questionCreated.get());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/{questionId}")
    public ResponseEntity<QuestionDto> updateQuestion(@PathVariable Integer categoryId, @PathVariable Long questionId ,@RequestBody  QuestionDto questionDto) throws QuestionNotFoundException {
        Optional<QuestionDto> questionDtoFromService = questionService.updateQuestion(categoryId,questionId,questionDto) ;
        if(questionDtoFromService.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(questionDtoFromService.get());
        }
        throw  new QuestionNotFoundException("Question not found");
    }

    @PatchMapping("/{questionId}")
    public ResponseEntity<QuestionDto> updateQuestionPartially(@PathVariable Integer categoryId, @PathVariable Long questionId ,@RequestBody  QuestionDto questionDto) throws QuestionNotFoundException {
        Optional<QuestionDto> questionDtoFromService = questionService.updatePartiallyQuestion(categoryId,questionId,questionDto) ;
        if(questionDtoFromService.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(questionDtoFromService.get());
        }
        throw  new QuestionNotFoundException("Question not found");
    }

    @DeleteMapping("/{questionId}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long questionId) throws QuestionNotFoundException {
        questionService.deleteQuestion(questionId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<List<QuestionDto>> getAllQuestions(){
        return ResponseEntity.status(HttpStatus.OK).body(questionService.getAllQuestions().get());
    }

    @GetMapping("/{questionId}")
    public ResponseEntity<QuestionDto> getOneQuestion(@PathVariable Long questionId) throws QuestionNotFoundException {
        Optional<QuestionDto> questionDtoFromDb = questionService.getOneQuestion(questionId);
        if(questionDtoFromDb.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(questionDtoFromDb.get());
        }
       throw  new QuestionNotFoundException("Question not found");
    }

}
