package com.faculdade.tcc.domain.dtos.requests;

import com.faculdade.tcc.domain.questionnaire.Questionnaire;

import java.util.UUID;

public record QuestionRequestDTO(UUID idQuestionnaire, String description, Integer idOrder) {
}
