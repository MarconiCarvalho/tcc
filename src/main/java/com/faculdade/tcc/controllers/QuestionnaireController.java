package com.faculdade.tcc.controllers;

import com.faculdade.tcc.domain.dtos.requests.QuestionnaireRequestDTO;
import com.faculdade.tcc.domain.dtos.responses.QuestionnaireResponseDTO;
import com.faculdade.tcc.domain.questionnaire.Questionnaire;
import com.faculdade.tcc.service.QuestionnarieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {

    @Autowired
    private QuestionnarieService questionnaireService;

    @PostMapping
    public ResponseEntity<Questionnaire> createQuestionnaire(@RequestBody QuestionnaireRequestDTO requestDTO) throws Exception {
        Questionnaire newQuestionnaire = questionnaireService.createQuestionnarie(requestDTO);
        return new ResponseEntity<>(newQuestionnaire, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Questionnaire> findQuestionnaireById(@PathVariable UUID id){
        Questionnaire questionnaire = questionnaireService.findById(id);
        if(questionnaire != null){
            return new ResponseEntity<>(questionnaire, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    public ResponseEntity <List<QuestionnaireResponseDTO>> findAllQuestionnaire(){
        List<Questionnaire> questionnaire = questionnaireService.findAllQuestionnarie();
        List<QuestionnaireResponseDTO> response = questionnaire.stream().map(QuestionnaireResponseDTO::new).toList();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Questionnaire> updateQuestionnaire(@PathVariable UUID id, @RequestBody QuestionnaireRequestDTO questionnaireRequestDTO) throws Exception {
        Questionnaire updatequestionnaire = questionnaireService.updateQuestionnaire(id, questionnaireRequestDTO);
        if (updatequestionnaire != null){
            return new ResponseEntity<>(updatequestionnaire, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestionnaire(@PathVariable UUID id){
        boolean deleted = questionnaireService.deleteQuestionnarie(id);
        if (deleted){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }
}
