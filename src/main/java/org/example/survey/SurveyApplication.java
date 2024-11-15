package org.example.survey;

import lombok.RequiredArgsConstructor;
import org.example.survey.dto.request.CategoryRequestDto;
import org.example.survey.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class SurveyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SurveyApplication.class, args);
    }
    private final CategoryService categoryService;
    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {

        };
    }

}
