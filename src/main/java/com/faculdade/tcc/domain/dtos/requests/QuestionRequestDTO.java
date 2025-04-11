package com.faculdade.tcc.domain.dtos.requests;

import com.faculdade.tcc.domain.questionnaire.Questionnaire;

public record QuestionRequestDTO(Questionnaire idQuestionnaire, String description, Integer order) {
}
