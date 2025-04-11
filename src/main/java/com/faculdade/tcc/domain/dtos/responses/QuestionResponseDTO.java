package com.faculdade.tcc.domain.dtos.responses;

import com.faculdade.tcc.domain.question.Question;
import com.faculdade.tcc.domain.questionnaire.Questionnaire;

import java.util.UUID;

public record QuestionResponseDTO(UUID id, Questionnaire idQuestionnaire, String description, Integer order) {

    public QuestionResponseDTO(Question question){
        this(question.getId(), question.getIdQuestionnaire(), question.getDescription(), question.getOrder());
    }
}
