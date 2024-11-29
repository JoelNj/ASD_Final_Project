package org.example.survey.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.survey.dto.QuestionDto;

import java.util.List;

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

    @OneToMany(mappedBy = "userAnswer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AssesmentQuestion> assessmentQuestions;



}
