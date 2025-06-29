package com.faculdade.tcc.controllers;

import com.faculdade.tcc.domain.dtos.requests.QuestionRequestDTO;
import com.faculdade.tcc.domain.question.Question;
import com.faculdade.tcc.domain.dtos.responses.QuestionResponseDTO;
import com.faculdade.tcc.service.QuestionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/question")
@Tag(name = "Questão", description = "API para gerenciar questões")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping
    @Operation(summary = "Cria questões")
    public ResponseEntity<Question> createQuestion(@RequestBody QuestionRequestDTO questionDTO) throws Exception {
        Question newQuestion = questionService.createQuestion(questionDTO);
        return new ResponseEntity<>(newQuestion, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Lista todas as questões")
    public ResponseEntity<List<QuestionResponseDTO>> findAllQuestion(){
        List<Question> question = questionService.findAllQuestion();
        List<QuestionResponseDTO> response = question.stream().map(QuestionResponseDTO::new).toList();
        return ResponseEntity.ok(response);
    }


    @GetMapping("/questionnaire/{id}")
    @Operation(summary = "Busca questões por ID do questionario", description = "Retorna uma Lista com as questões vinculadas ao questionario ")
    public ResponseEntity<List<Question>> findQuestionsByQuestionnaire(@PathVariable UUID id) {
        List<Question> questions = questionService.findByIdQuestionnaire(id);
        return questions.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(questions);
        }



    @GetMapping("/{id}")
    @Operation(summary = "Busca questão por ID")
    public ResponseEntity<Question>findQuestionById(@PathVariable UUID id) throws Exception {
      Question question = questionService.findById(id);
      if(question != null){
          return new ResponseEntity<>(question, HttpStatus.OK);
      }else {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza questões por ID")
    public ResponseEntity<Question> updateQuestion(@PathVariable UUID id, @RequestBody QuestionRequestDTO questionRequestDTO){
        Question updateQuestion = questionService.updateQuestion(id , questionRequestDTO);
        if (updateQuestion != null){
            return new ResponseEntity<>(updateQuestion, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta questões por ID")
    public ResponseEntity<Void> deleteQuestion(@PathVariable UUID id){
        boolean deleted = questionService.deleteQuestionById(id);
        if(deleted){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
