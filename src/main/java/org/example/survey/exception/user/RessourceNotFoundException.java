package org.example.survey.exception.user;

public class RessourceNotFoundException extends RuntimeException  {
    public RessourceNotFoundException(String message) {
        super(message);
    }
}
