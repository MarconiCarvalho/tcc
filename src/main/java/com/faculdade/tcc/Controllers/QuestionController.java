package com.faculdade.tcc.Controllers;

import com.faculdade.tcc.domain.dtos.requests.QuestionRequestDTO;
import com.faculdade.tcc.domain.question.Question;
import com.faculdade.tcc.domain.dtos.responses.QuestionResponseDTO;
import com.faculdade.tcc.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping
    public ResponseEntity<Question> createQuestion(@RequestBody QuestionRequestDTO questionDTO){
        Question newQuestion = this.questionService.createUser(questionDTO);
        return new ResponseEntity<>(newQuestion, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<QuestionResponseDTO>> findAllQuestion(){
        List<Question> question = this.questionService.findAllQuestion();
        List<QuestionResponseDTO> response = question.stream().map(QuestionResponseDTO::new).toList();
        return ResponseEntity.ok(response);
    }

}
