package org.example.survey.auth;


import org.example.survey.model.Category;
import org.example.survey.model.Role;

public record RegisterRequest(
        String firstName,
        String lastName,
        String username,
        String password,
        Role role,
        Category category
) {
}
