package org.example.survey.exception.user;

public class AnswerNotFoundException extends RuntimeException {
  public AnswerNotFoundException(String message) {
    super(message);
  }
}
