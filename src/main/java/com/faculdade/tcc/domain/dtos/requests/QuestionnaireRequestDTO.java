package com.faculdade.tcc.domain.dtos.requests;

import java.time.LocalDateTime;

public record QuestionnaireRequestDTO(String title, String description, LocalDateTime creationDate) {
}
