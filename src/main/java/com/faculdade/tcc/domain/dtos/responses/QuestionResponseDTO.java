package com.faculdade.tcc.domain.dtos.responses;

import com.faculdade.tcc.domain.question.Question;
import com.faculdade.tcc.domain.questionnaire.Questionnaire;

import java.time.LocalDateTime;
import java.util.UUID;

public record QuestionResponseDTO( UUID idQuestionnaire, String description, Integer idOrder, UUID createBy, UUID updateBy, LocalDateTime createAt, LocalDateTime updateAt) {

    public QuestionResponseDTO(Question question){
        this(
                question.getIdQuestionnaire() != null ? question.getIdQuestionnaire().getId() : null,
                question.getDescription(),
                question.getOrder(),
                question.getCreateBy().getId(),
                question.getCreateAt() != null ? question.getUpdateBy().getId() : null,
                question.getUpdateAt(),
                question.getCreateAt());
    }
}
