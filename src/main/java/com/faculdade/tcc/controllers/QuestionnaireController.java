package com.faculdade.tcc.controllers;

import com.faculdade.tcc.domain.dtos.requests.QuestionnaireRequestDTO;
import com.faculdade.tcc.domain.dtos.responses.QuestionnaireResponseDTO;
import com.faculdade.tcc.domain.questionnaire.Questionnaire;
import com.faculdade.tcc.service.QuestionnarieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/questionnaire")
@Tag(name = "Questionario", description = "API para gerenciar questionarios")
public class QuestionnaireController {

    @Autowired
    private QuestionnarieService questionnaireService;

    @PostMapping
    @Operation(summary = "Cria um novo questionario", description = "retorna o questionario com um HttpStatus")
    public ResponseEntity<Questionnaire> createQuestionnaire(@RequestBody QuestionnaireRequestDTO requestDTO) throws Exception {
        Questionnaire newQuestionnaire = questionnaireService.createQuestionnarie(requestDTO);
        return new ResponseEntity<>(newQuestionnaire, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca questionario por ID")
    public ResponseEntity<Questionnaire> findQuestionnaireById(@PathVariable UUID id){
        Questionnaire questionnaire = questionnaireService.findById(id);
        if(questionnaire != null){
            return new ResponseEntity<>(questionnaire, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    @Operation(summary = "Lista todas as questões", description = "retorna um DTO com uma lista de questionarios")
    public ResponseEntity <List<QuestionnaireResponseDTO>> findAllQuestionnaire(){
        List<Questionnaire> questionnaire = questionnaireService.findAllQuestionnarie();
        List<QuestionnaireResponseDTO> response = questionnaire.stream().map(QuestionnaireResponseDTO::new).toList();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza questionario por ID", description = "Retorna o questionario com HttpStatus")
    public ResponseEntity<Questionnaire> updateQuestionnaire(@PathVariable UUID id, @RequestBody QuestionnaireRequestDTO questionnaireRequestDTO) throws Exception {
        Questionnaire updatequestionnaire = questionnaireService.updateQuestionnaire(id, questionnaireRequestDTO);
        if (updatequestionnaire != null){
            return new ResponseEntity<>(updatequestionnaire, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta questionario por ID")
    public ResponseEntity<Void> deleteQuestionnaire(@PathVariable UUID id){
        boolean deleted = questionnaireService.deleteQuestionnarie(id);
        if (deleted){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }
}
