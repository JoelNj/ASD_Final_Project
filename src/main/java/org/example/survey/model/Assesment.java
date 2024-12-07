package org.example.survey.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;


@Entity
@RequiredArgsConstructor
@Data
public class Assesment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    private String result; // new - not started - started - completed

    private Double percentage;

    @OneToMany(mappedBy = "assesment", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AssesmentQuestion> assessmentQuestions;


}
