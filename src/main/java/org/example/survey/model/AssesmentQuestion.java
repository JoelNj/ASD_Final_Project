package org.example.survey.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@Data
public class AssesmentQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @ManyToOne(fetch = FetchType.LAZY)
    private Question question ;

    @ManyToOne(fetch = FetchType.LAZY)
    private Assesment assesment ;

    @ManyToOne(fetch = FetchType.LAZY)
    private Answer userAnswer ;

    private Boolean isTrue;

    private Boolean isResponded;

}
