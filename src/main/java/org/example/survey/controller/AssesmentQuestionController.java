package org.example.survey.controller;


import lombok.RequiredArgsConstructor;
import org.example.survey.dto.*;
import org.example.survey.model.AssesmentQuestion;
import org.example.survey.model.Category;
import org.example.survey.model.User;
import org.example.survey.repository.UserRepository;
import org.example.survey.service.AssesmentQuestionService;
import org.example.survey.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users/{userId}/assesments/{assesmentId}/assesmentquestions")
@RequiredArgsConstructor
public class AssesmentQuestionController {

    private final AssesmentQuestionService assesmentQuestionService;
    private final QuestionService questionService;
    private final UserRepository userRepository;

    @PostMapping()
    public ResponseEntity<?> addAssesmentQuestion(@PathVariable Long userId,
                                                             @PathVariable Long assesmentId,
                                                             @RequestBody RequestAssesmentQuestionDto requestAssesmentQues
                                                  tionDto){
        User user = userRepository.findById(userId).orElseThrow();
        List<QuestionDto> listOfQuestionDto = questionService.getKRandomQuestionsBasedOnCategory(user.getCategory().getNumberOfQuestion()).get();
        for (QuestionDto questionDto : listOfQuestionDto) {
            assesmentQuestionService.addAssesmentQuestion(assesmentId,questionDto.questionId(),requestAssesmentQuestionDto);
        }
        List<ResponseAssesmentQuestionDto> assesmentQuestions = assesmentQuestionService.getAllQuestionForAssesment(assesmentId).get();
        return ResponseEntity.status(HttpStatus.CREATED).body(assesmentQuestions);

    }

    @PutMapping("/{assesmentQuestionId}")
    public ResponseEntity<ResponseAssesmentQuestionDto> updateAssesmentQuestion(@PathVariable Long assesmentQuestionId,
                                                             @RequestBody AnswerDto answerDto){
        Optional<ResponseAssesmentQuestionDto> assesmentQuestion =
                assesmentQuestionService.updateAssesmentQuestionWithUserResponse(assesmentQuestionId,answerDto);

         if(assesmentQuestion.isPresent()){
             return ResponseEntity.status(HttpStatus.OK).body(assesmentQuestion.get());
         }
         throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Assesment question not found");

    }

}
