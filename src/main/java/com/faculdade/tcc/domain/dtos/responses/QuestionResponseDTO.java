package com.faculdade.tcc.domain.dtos.responses;

import com.faculdade.tcc.domain.question.Question;

import java.time.LocalDateTime;
import java.util.UUID;

public record QuestionResponseDTO(UUID idQuestionnaire, String description, Integer idOrder, UUID createBy, UUID updateBy, LocalDateTime createAt, LocalDateTime updateAt) {

    public QuestionResponseDTO(Question question){
        this(
                question.getIdQuestionnaire(),
                question.getDescription(),
                question.getOrder(),
                question.getCreateBy(),
                question.getCreateBy(),
                question.getUpdateAt(),
                question.getCreateAt());
    }
}
