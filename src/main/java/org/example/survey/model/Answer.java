package org.example.survey.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@Data
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long responseId;

    private String responseText;

    private Boolean isTrue;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question ;

    public Answer(String responseText, Boolean isTrue,Question question) {
        this.responseText = responseText;
        this.isTrue = isTrue;
        this.question=question;
    }

}
