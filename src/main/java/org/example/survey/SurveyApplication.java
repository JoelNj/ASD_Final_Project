package org.example.survey;

import lombok.RequiredArgsConstructor;

import org.example.survey.dto.AssesmentDto;
import org.example.survey.dto.CategoryDto;
import org.example.survey.dto.QuestionDto;
import org.example.survey.mapper.AnswerMapper;
import org.example.survey.mapper.AssesmentMapper;
import org.example.survey.mapper.CategoryMapper;
import org.example.survey.model.Category;
import org.example.survey.model.User;
import org.example.survey.repository.AnswerRepository;
import org.example.survey.repository.CategoryRepository;
import org.example.survey.repository.UserRepository;
import org.example.survey.service.AnswerService;
import org.example.survey.service.AssesmentService;
import org.example.survey.service.CategoryService;
import org.example.survey.service.QuestionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;


@SpringBootApplication
@RequiredArgsConstructor
public class SurveyApplication {



    public static void main(String[] args) {
        SpringApplication.run(SurveyApplication.class, args);
    }

}
