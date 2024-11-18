package org.example.survey;

import lombok.RequiredArgsConstructor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@RequiredArgsConstructor
public class SurveyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SurveyApplication.class, args);
    }


}
