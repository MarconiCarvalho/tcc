package com.faculdade.tcc.domain.dtos.responses;

import com.faculdade.tcc.domain.questionnaire.Questionnaire;

import java.time.LocalDateTime;

public record QuestionnaireResponseDTO(String title, String description, LocalDateTime creationDate) {

   public QuestionnaireResponseDTO(Questionnaire questionnaire){
       this(questionnaire.getTitle(), questionnaire.getDescription(), questionnaire.getCreationDate());
   }
}
