package org.example.survey.controller;


import lombok.RequiredArgsConstructor;
import org.example.survey.auth.AuthenticationRequest;
import org.example.survey.auth.AuthenticationResponse;
import org.example.survey.auth.AuthenticationService;
import org.example.survey.auth.RegisterRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest) {

        AuthenticationResponse authenticationResponse = authenticationService.register(registerRequest);
        if (authenticationResponse!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(authenticationResponse);
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();

    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        AuthenticationResponse authenticationResponse = authenticationService.authenticate(authenticationRequest);

        return ResponseEntity.ok(authenticationResponse);
    }
}
