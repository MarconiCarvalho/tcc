package com.faculdade.tcc.domain.dtos.responses;

import com.faculdade.tcc.domain.questionnaire.Questionnaire;
import com.faculdade.tcc.domain.user.User;
import java.time.LocalDateTime;
import java.util.UUID;

public record QuestionnaireResponseDTO(String title, String description, UUID createBy, LocalDateTime createAt, UUID updateBy, LocalDateTime updateAt) {

   public QuestionnaireResponseDTO(Questionnaire questionnaire){
       this(
               questionnaire.getTitle(),
               questionnaire.getDescription(),
               questionnaire.getCreateBy().getId(),
               questionnaire.getCreateAt(),
               questionnaire.getUpdateBy() != null ? questionnaire.getUpdateBy().getId() : null,
               questionnaire.getUpdateAt());
   }
}
