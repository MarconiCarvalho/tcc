package com.faculdade.tcc.Controllers;

import com.faculdade.tcc.domain.answers.Answers;
import com.faculdade.tcc.domain.dtos.requests.AnswersRequestDTO;
import com.faculdade.tcc.domain.dtos.requests.QuestionRequestDTO;
import com.faculdade.tcc.domain.dtos.responses.AnswersResponseDTO;
import com.faculdade.tcc.domain.question.Question;
import com.faculdade.tcc.service.AnswersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/answers")
public class AnswersController {

    @Autowired
    private AnswersService answersService;

    @PostMapping
    public ResponseEntity<Answers> createAnswers(@RequestBody AnswersRequestDTO answersRequestDTO){
        Answers newAnswers = answersService.createAnswers(answersRequestDTO);
        return new ResponseEntity<>(newAnswers, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AnswersResponseDTO>> findAllAnswers(){
        List<Answers> answers = answersService.findAllAnswers();
        List<AnswersResponseDTO> response =  answers.stream().map(AnswersResponseDTO :: new).toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Answers>findByIdAnswers(@PathVariable UUID id) throws Exception {
        Answers answers = answersService.findById(id);
        if(answers != null){
            return new ResponseEntity<>(answers, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnswers(@PathVariable UUID id){
        boolean deleted = answersService.deleteAnswers(id);
        if(deleted){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
