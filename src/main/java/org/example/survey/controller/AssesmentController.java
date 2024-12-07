package org.example.survey.controller;


import lombok.RequiredArgsConstructor;
import org.example.survey.dto.AnswerDto;
import org.example.survey.dto.AssesmentDto;
import org.example.survey.dto.QuestionDto;
import org.example.survey.exception.RessourceNotFoundException;
import org.example.survey.model.AssesmentQuestion;
import org.example.survey.model.Category;
import org.example.survey.repository.UserRepository;
import org.example.survey.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users/{userId}/assesments")
@RequiredArgsConstructor
public class AssesmentController {

    private final AssesmentService assesmentService;
    private final QuestionService questionService;
    private final CategoryService categoryService;
    private final UserRepository userRepository;


    @PostMapping()
    public ResponseEntity<AssesmentDto> addAssesment(@PathVariable Long userId, @RequestBody AssesmentDto assesmentDto){
        Optional<AssesmentDto> assesmentCreated = assesmentService.addAssesment(userId, assesmentDto);
        Category categoryOfUser = userRepository.findByUserId(userId).get().getCategory();

        if(assesmentCreated.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(assesmentCreated.get());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/{assesmentId}")
    public ResponseEntity<AssesmentDto> updateAssesment(@PathVariable Long assesmentId ,@RequestBody AssesmentDto assesmentDto) throws RessourceNotFoundException {
        Optional<AssesmentDto> assesmentDtoFromDb = assesmentService.updateAssesment(assesmentId, assesmentDto);
        if(assesmentDtoFromDb .isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(assesmentDtoFromDb.get());
        }
        throw  new RessourceNotFoundException("Assesment not found");
    }

    @GetMapping("/{assesmentId}")
    public ResponseEntity<AssesmentDto> getOneAssesment(@PathVariable Long assesmentId) throws RessourceNotFoundException {
        Optional<AssesmentDto> assesmentDtoFromDb = assesmentService.getOneAssesmentById(assesmentId);
        if(assesmentDtoFromDb.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(assesmentDtoFromDb.get());
        }
        throw  new RessourceNotFoundException("Assesment not found");

    }

    @DeleteMapping("/{assesmentId}")
    public ResponseEntity<Void> deleteAssesment(@PathVariable Long assesmentId) throws RessourceNotFoundException {
        assesmentService.deleteAssesment(assesmentId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping()
    public ResponseEntity<List<AssesmentDto>> getListAssesmentByUserId(@PathVariable Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(assesmentService.getListAssesmentByUserId(userId).get());
    }

}
