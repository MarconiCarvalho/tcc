package com.faculdade.tcc.domain.dtos;

import com.faculdade.tcc.domain.questionnaire.Questionnaire;

public record QuestionDTO(Questionnaire idQuestionnaire, String description, Integer ordem) {
}
