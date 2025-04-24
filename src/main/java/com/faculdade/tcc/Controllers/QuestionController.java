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
import java.util.UUID;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping
    public ResponseEntity<Question> createQuestion(@RequestBody QuestionRequestDTO questionDTO) throws Exception {
        Question newQuestion = questionService.createQuestion(questionDTO);
        return new ResponseEntity<>(newQuestion, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<QuestionResponseDTO>> findAllQuestion(){
        List<Question> question = questionService.findAllQuestion();
        List<QuestionResponseDTO> response = question.stream().map(QuestionResponseDTO::new).toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question>findQuestionById(@PathVariable UUID id) throws Exception {
      Question question = questionService.findById(id);
      if(question != null){
          return new ResponseEntity<>(question, HttpStatus.OK);
      }else {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable UUID id, @RequestBody QuestionRequestDTO questionRequestDTO){
        Question updateQuestion = questionService.updateQuestion(id , questionRequestDTO);
        if (updateQuestion != null){
            return new ResponseEntity<>(updateQuestion, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable UUID id){
        boolean deleted = questionService.deleteQuestionById(id);
        if(deleted){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
