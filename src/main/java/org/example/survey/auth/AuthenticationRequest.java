package org.example.survey.auth;

public record AuthenticationRequest(
        String username,
        String password
) {
}
