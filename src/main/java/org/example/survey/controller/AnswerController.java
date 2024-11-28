package org.example.survey.controller;


import lombok.RequiredArgsConstructor;
import org.example.survey.dto.AnswerDto;
import org.example.survey.service.AnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/categories/{categoryId}/questions/{questionId}/answers")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;
    @PostMapping
    public ResponseEntity<AnswerDto> addAnswer(@PathVariable Long questionId, @RequestBody AnswerDto answerDto){
        Optional<AnswerDto> answerCreated = answerService.addAnswer(questionId, answerDto);
        if(answerCreated .isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(answerCreated.get());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/{answerId}")
    public ResponseEntity<AnswerDto> updateAnswer(@PathVariable Long questionId , @PathVariable Long answerId ,@RequestBody  AnswerDto answerDto) throws CategoryNotFoundException {
        Optional<AnswerDto> answerDtoFromDb = answerService.updateAnswer(questionId, answerId, answerDto);
        if(answerDtoFromDb.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(answerDtoFromDb.get());
        }
        throw  new CategoryNotFoundException("Answer not found");
    }

    @PatchMapping("/{answerId}")
    public ResponseEntity<AnswerDto> updateAnswerPartially(@PathVariable Long questionId , @PathVariable Long answerId ,@RequestBody  AnswerDto answerDto) throws CategoryNotFoundException {
        Optional<AnswerDto> answerDtoFromDb = answerService.updateAnswerPartially(questionId, answerId, answerDto);
        if(answerDtoFromDb.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(answerDtoFromDb.get());
        }
        throw  new CategoryNotFoundException("Answer not found");
    }

    @DeleteMapping("/{answerId}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long answerId) throws CategoryNotFoundException {
        answerService.deleteAnswer(answerId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<List<AnswerDto>> getAllQuestions(){
        return ResponseEntity.status(HttpStatus.OK).body(answerService.getAllAnswers().get());
    }
    @GetMapping("/{answerId}")
    public ResponseEntity<AnswerDto> getOneAnswer(@PathVariable Long answerId) throws AnswerNotFoundException {
        Optional<AnswerDto> answerDtoFromDb = answerService.getOneAnswer(answerId);
        if(answerDtoFromDb.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(answerDtoFromDb.get());
        }
        throw  new AnswerNotFoundException("Answer not found");
    }
}
