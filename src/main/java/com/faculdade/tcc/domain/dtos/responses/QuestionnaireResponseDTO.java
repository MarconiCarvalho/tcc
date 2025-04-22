package com.faculdade.tcc.domain.dtos.responses;

import com.faculdade.tcc.domain.questionnaire.Questionnaire;
import com.faculdade.tcc.domain.user.User;
import java.time.LocalDateTime;

public record QuestionnaireResponseDTO(String title, String description, User createBy, LocalDateTime createAt, User updateBy, LocalDateTime updateAt) {

   public QuestionnaireResponseDTO(Questionnaire questionnaire){
       this(questionnaire.getTitle(), questionnaire.getDescription(), questionnaire.getCreateBy(), questionnaire.getCreateAt(), questionnaire.getUpdateBy(), questionnaire.getUpdateAt());
   }
}
