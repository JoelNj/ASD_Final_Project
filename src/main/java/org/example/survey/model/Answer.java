package org.example.survey.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.survey.dto.QuestionDto;

@Entity
@RequiredArgsConstructor
@Data
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long responseId;

    String responseText;

    Boolean isTrue;

    @ManyToOne
    @JoinColumn(name = "question_id")
    Question question;



}
