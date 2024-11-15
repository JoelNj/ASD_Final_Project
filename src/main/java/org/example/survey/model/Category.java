package org.example.survey.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    private String label;
    private Integer numberOfQuestion;

    public Category(String label, Integer numberOfQuestion) {
        this.label = label;
        this.numberOfQuestion = numberOfQuestion;
    }
}
