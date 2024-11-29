package org.example.survey.controller;


import lombok.RequiredArgsConstructor;
import org.example.survey.dto.AnswerDto;
import org.example.survey.dto.AssesmentDto;
import org.example.survey.exception.user.RessourceNotFoundException;
import org.example.survey.service.AnswerService;
import org.example.survey.service.AssesmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/assesments")
@RequiredArgsConstructor
public class AssesmentController {

    private final AssesmentService assesmentService;

    @PutMapping("/{assesmentId}")
    public ResponseEntity<AssesmentDto> updateAssesment(@PathVariable Long assesmentId ,@RequestBody AssesmentDto assesmentDto) throws RessourceNotFoundException {
        Optional<AssesmentDto> assesmentDtoFromDb = assesmentService.updateAssesment(assesmentId, assesmentDto);
        if(assesmentDtoFromDb .isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(assesmentDtoFromDb.get());
        }
        throw  new RessourceNotFoundException("Assesment not found");
    }

    @DeleteMapping("/{assesmentId}")
    public ResponseEntity<Void> deleteAssesment(@PathVariable Long assesmentId) throws RessourceNotFoundException {
        assesmentService.deleteAssesment(assesmentId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<List<AssesmentDto>> getAllAssesment(){
        return ResponseEntity.status(HttpStatus.OK).body(assesmentService.getAllAssesments().get());
    }

    @GetMapping("/{assesmentId}")
    public ResponseEntity<AssesmentDto> getOneAssesment(@PathVariable Long assesmentId) throws RessourceNotFoundException {
        Optional<AssesmentDto> assesmentDtoFromDb = assesmentService.getOneAssesmentById(assesmentId);
        if(assesmentDtoFromDb.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(assesmentDtoFromDb.get());
        }
        throw  new RessourceNotFoundException("Assesment not found");

    }
}
