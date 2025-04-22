package com.faculdade.tcc.domain.dtos.requests;

import java.time.LocalDateTime;
import java.util.UUID;

public record QuestionnaireRequestDTO(String title, String description, UUID createBy, UUID updateBy){
}
