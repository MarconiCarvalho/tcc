package com.faculdade.tcc.domain.dtos;

import java.time.LocalDateTime;

public record QuestionnarieDTO(String title, String description, LocalDateTime creationDate) {
}
