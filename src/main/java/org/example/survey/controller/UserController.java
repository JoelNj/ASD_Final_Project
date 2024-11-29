package org.example.survey.controller;

import lombok.RequiredArgsConstructor;
import org.example.survey.dto.AssesmentDto;
import org.example.survey.repository.AssesmentRepository;
import org.example.survey.repository.UserRepository;
import org.example.survey.service.AssesmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users/{userId}/assesments")
@RequiredArgsConstructor
public class UserController {

    private final AssesmentService assesmentService;

    @PostMapping()
    public ResponseEntity<AssesmentDto> addAssesment(@PathVariable Long userId, @RequestBody AssesmentDto assesmentDto){
        Optional<AssesmentDto> assesmentCreated = assesmentService.addAssesment(userId, assesmentDto);
        if(assesmentCreated.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(assesmentCreated.get());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping()
    public ResponseEntity<List<AssesmentDto>> getListAssesmentByUserId(@PathVariable Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(assesmentService.getListAssesmentByUserId(userId).get());
    }

}
