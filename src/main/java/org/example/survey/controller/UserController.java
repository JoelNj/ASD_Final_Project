package org.example.survey.controller;

import lombok.RequiredArgsConstructor;
import org.example.survey.dto.AssesmentDto;
import org.example.survey.model.User;
import org.example.survey.repository.AssesmentRepository;
import org.example.survey.repository.UserRepository;
import org.example.survey.service.AssesmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping()
    public ResponseEntity<List<User>> getListOfAllUser(){
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.findAll());
    }

}
