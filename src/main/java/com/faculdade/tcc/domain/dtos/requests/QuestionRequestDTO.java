package com.faculdade.tcc.domain.dtos.requests;

import java.util.UUID;

public record QuestionRequestDTO(UUID idQuestionnaire, String description, Integer idOrder) {
}
