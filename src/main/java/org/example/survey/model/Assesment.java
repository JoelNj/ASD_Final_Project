package org.example.survey.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.survey.data.user.User;

import java.util.List;
import java.util.Set;


@Entity
@RequiredArgsConstructor
@Data
public class Assesment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private String result;

    private Double percentage;

    @OneToMany(mappedBy = "assesment", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AssesmentQuestion> assessmentQuestions;



}
