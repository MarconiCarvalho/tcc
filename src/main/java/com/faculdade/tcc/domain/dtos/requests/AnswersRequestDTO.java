package com.faculdade.tcc.domain.dtos.requests;

import com.faculdade.tcc.domain.answers.OptionAnswers;

import java.util.UUID;

public record AnswersRequestDTO(OptionAnswers option, UUID idQuestion, UUID userId) {
}
