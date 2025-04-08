package com.faculdade.tcc.domain.dtos;

import com.faculdade.tcc.domain.questionnaire.Questionnarie;

public record QuestionDTO(Questionnarie idQuestionnaire, String description, Integer ordem) {
}
