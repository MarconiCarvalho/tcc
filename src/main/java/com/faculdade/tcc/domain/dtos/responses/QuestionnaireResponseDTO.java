package com.faculdade.tcc.domain.dtos.responses;

import com.faculdade.tcc.domain.questionnaire.Questionnaire;
import com.faculdade.tcc.domain.user.User;
import java.time.LocalDateTime;
import java.util.UUID;

public record QuestionnaireResponseDTO(UUID id,String title, String description, UUID createBy, LocalDateTime createAt, UUID updateBy, LocalDateTime updateAt) {

   public QuestionnaireResponseDTO(Questionnaire questionnaire){
       this(
               questionnaire.getId(),
               questionnaire.getTitle(),
               questionnaire.getDescription(),
               questionnaire.getCreateBy(),
               questionnaire.getCreateAt(),
               questionnaire.getUpdateBy() ,
               questionnaire.getUpdateAt());
   }
}
