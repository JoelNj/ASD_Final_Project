package org.example.survey.auth;


import org.example.survey.data.user.Role;

public record RegisterRequest(
        String firstName,
        String lastName,
        String username,
        String password,
        Role role
) {
}
