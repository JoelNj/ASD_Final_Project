package org.example.survey.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@RequiredArgsConstructor
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long questionId;

    private String questionText;

    private Boolean hasAnswer;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category ;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Answer> answers;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AssesmentQuestion> assessmentQuestions;


    public Question(String questionText, Boolean hasAnswer,Category category) {
        this.questionText = questionText;
        this.hasAnswer = hasAnswer;
        this.category=category;
    }
}
